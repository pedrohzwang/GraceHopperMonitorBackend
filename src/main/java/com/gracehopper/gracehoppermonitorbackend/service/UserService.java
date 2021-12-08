package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.dto.UserDTO;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    public UserDTO getUserById(Long id) {
        User user = repository.getById(id);
        return new UserDTO(user);
    }

    public void getInactiveTime(Long userId) {
        User user = repository.getById(userId);


    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
