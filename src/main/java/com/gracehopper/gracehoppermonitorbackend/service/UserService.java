package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.dto.UserTokenDTO;
import com.gracehopper.gracehoppermonitorbackend.exception.UserException;
import com.gracehopper.gracehoppermonitorbackend.dto.UserDTO;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    public UserDTO getUserById(Integer id) {
        User user = repository.getById(id);
        return new UserDTO(user);
    }

    public void getInactiveTime(Integer userId) {
        User user = repository.getById(userId);


    }

    public void changePassword(Integer id, String newPassowrd) {
        User user = repository.getById(id);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    public void changeToken(Integer id, UserTokenDTO newToken) {
        User user = repository.getById(id);
        user.setAccessToken(newToken.getAccessToken());
        repository.save(user);
    }

    public void changeUserInfo(User newUserInfo) {
        User user = repository.getById(newUserInfo.getUserId());
        user.setName(newUserInfo.getName());
        user.setUsername(newUserInfo.getUsername());
        user.setPassword(encoder.encode(newUserInfo.getPassword()));
        user.setAccessToken(newUserInfo.getAccessToken());
        user.setPost(newUserInfo.getPost());
        user.setUserRole(newUserInfo.getUserRole());
        repository.save(user);
    }

    public void saveUser(User user) throws UserException {
        List<User> users = repository.existsUserByUsername(user.getUsername());
        if (users.isEmpty()) {
            user.setPassword(encoder.encode(user.getPassword()));
            repository.save(user);
        } else {
            throw new UserException("Username already exists!");
        }
    }

    public void deleteUser(Integer id) {
        User user = repository.getById(id);
        repository.delete(user);
    }
}
