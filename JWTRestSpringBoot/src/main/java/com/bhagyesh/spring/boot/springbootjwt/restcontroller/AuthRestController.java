package com.bhagyesh.spring.boot.springbootjwt.restcontroller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyesh.spring.boot.springbootjwt.jwt.JwtProvider;
import com.bhagyesh.spring.boot.springbootjwt.model.JwtResponse;
import com.bhagyesh.spring.boot.springbootjwt.model.LoginInfo;
import com.bhagyesh.spring.boot.springbootjwt.model.ResponseMessage;
import com.bhagyesh.spring.boot.springbootjwt.model.Role;
import com.bhagyesh.spring.boot.springbootjwt.model.RoleName;
import com.bhagyesh.spring.boot.springbootjwt.model.SignUp;
import com.bhagyesh.spring.boot.springbootjwt.model.User;
import com.bhagyesh.spring.boot.springbootjwt.repository.RoleRepository;
import com.bhagyesh.spring.boot.springbootjwt.repository.UserRepository;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthRestController {

	 @Autowired
	  AuthenticationManager authenticationManager;
	 
	  @Autowired
	  UserRepository userRepository;
	 
	  @Autowired
	  RoleRepository roleRepository;
	 
	  @Autowired
	  PasswordEncoder encoder;
	 
	  @Autowired
	  JwtProvider jwtProvider;
	
	@RequestMapping(method = RequestMethod.POST,value="/token")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginInfo logininfo) {
		 Authentication authentication = authenticationManager.authenticate(
	      new UsernamePasswordAuthenticationToken(logininfo.getUsername(), logininfo.getPassword()));
			    SecurityContextHolder.getContext().setAuthentication(authentication);
			    String jwt = jwtProvider.generateJwtToken(authentication);
			    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/singup")
	public ResponseEntity<?> registerUser(@RequestBody SignUp signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
	          HttpStatus.BAD_REQUEST);
	    }
	 
	    // Creating user's account
	    User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
	        encoder.encode(signUpRequest.getPassword()));
	 
	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();
	 
	    strRoles.forEach(role -> {
	      switch (role) {
	      case "admin":
	        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(adminRole);
	 
	        break;
	      case "pm":
	        Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(pmRole);
	 
	        break;
	      default:
	        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(userRole);
	      }
	    });
	 
	    user.setRoles(roles);
	    userRepository.save(user);
	 
	    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	  }
	}
	
