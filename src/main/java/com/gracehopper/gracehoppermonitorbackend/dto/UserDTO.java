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

    private Long userId;
    private String name;
    private String username;
    private String socialSecret;
    private String post;
    private Role userRole;
    private String address;
    private String phone;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.socialSecret = user.getSocialSecret();
        this.post = user.getPost();
        this.userRole = user.getUserRole();
        this.address = user.getAddress();
        this.phone = user.getPhone();
    }
}
