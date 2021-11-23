package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User getUserById(Long id) {
        return repository.getById(id);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}
