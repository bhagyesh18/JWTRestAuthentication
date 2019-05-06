package com.bhagyesh.spring.boot.springbootjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhagyesh.spring.boot.springbootjwt.model.User;
import com.bhagyesh.spring.boot.springbootjwt.model.UserPrinciple;
import com.bhagyesh.spring.boot.springbootjwt.repository.UserRepository;

import javax.transaction.Transactional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

	 @Autowired
	 private UserRepository userRepository;
	 
	  @Override
	  @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
     
        return UserPrinciple.build(user);

    }
}
