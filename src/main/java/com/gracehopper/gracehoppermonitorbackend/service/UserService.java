package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.dto.UserDTO;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserDTO getUserById(Long id) {
        User user = repository.getById(id);
        return new UserDTO(user);
    }

    public void getInactiveTime(Long userId) {
        User user = repository.getById(userId);


    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}
