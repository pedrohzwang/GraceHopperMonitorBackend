package com.gracehopper.gracehoppermonitorbackend.dto;

import com.gracehopper.gracehoppermonitorbackend.model.Role;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDTO {

    private Integer userId;
    private String name;
    private String username;
    private String post;
    private Role userRole;
    private String accessToken;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.post = user.getPost();
        this.userRole = user.getUserRole();
        this.accessToken = user.getAccessToken();
    }
}
