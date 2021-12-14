package com.gracehopper.gracehoppermonitorbackend.controller;

import com.gracehopper.gracehoppermonitorbackend.dto.UserTokenDTO;
import com.gracehopper.gracehoppermonitorbackend.exception.UserException;
import com.gracehopper.gracehoppermonitorbackend.dto.UserDTO;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getUserDTOById(id));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(service.saveUser(user));
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(path = "/{id}/changePassoword")
    public ResponseEntity changePassoword(@PathVariable Integer id, @RequestBody String newPassord) {
        service.changePassword(id, newPassord);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(path = "/changeInfo")
    public ResponseEntity changeUserInfo(@RequestBody User newUserInfo) {
        service.changeUserInfo(newUserInfo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/{id}/changeToken")
    public ResponseEntity changeAccessToken(@PathVariable Integer id, @RequestBody UserTokenDTO newToken) {
        service.changeToken(id, newToken);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
