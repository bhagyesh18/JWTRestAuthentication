package com.bhagyesh.spring.boot.springbootjwt.repository;


import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhagyesh.spring.boot.springbootjwt.model.Role;
import com.bhagyesh.spring.boot.springbootjwt.model.RoleName;
 
 
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
