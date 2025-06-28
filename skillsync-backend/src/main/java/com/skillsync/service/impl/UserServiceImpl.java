package com.skillsync.service.impl;

import com.skillsync.model.User;
import com.skillsync.repository.UserRepository;
import com.skillsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public User updateUser(Long id, User updateUser){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        existingUser.setName(updateUser.getName());
        existingUser.setEmail(updateUser.getEmail());
        existingUser.setPassword(updateUser.getPassword());
        existingUser.setRole(updateUser.getRole());
        return userRepository.save(existingUser);
    }
    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
