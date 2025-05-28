
package com.examly.springappuser.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.examly.springappuser.model.User;
import com.examly.springappuser.repository.UserRepo;

public class CustomeUserDetailsService implements UserDetailsService{
 
    private UserRepo userRepo;
    @Autowired
    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        String roleWithPrefix = "ROLE_"+user.getUserRole();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.singleton(new SimpleGrantedAuthority(roleWithPrefix)));
    }
    
}
