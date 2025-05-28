
package com.examly.springappuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springappuser.model.User;
import com.examly.springappuser.repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User createUser(User user){
       if(userRepo.findByEmail(user.getEmail())!=null){
        throw new IllegalArgumentException("User already exits");
       }
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepo.save(user);
    }
    @Override
    public User loginUser(String email, String password){
        User existingUser = userRepo.findByEmail(email);
        if(existingUser ==null||!passwordEncoder.matches(password, existingUser.getPassword())){
            throw new EntityNotFoundException("Invalid");
        }
        return existingUser;
    }
    
}

