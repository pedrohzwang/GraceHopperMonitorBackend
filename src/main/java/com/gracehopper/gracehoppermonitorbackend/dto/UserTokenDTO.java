package com.gracehopper.gracehoppermonitorbackend.dto;

import com.gracehopper.gracehoppermonitorbackend.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserTokenDTO {

    private String accessToken;

    public UserTokenDTO(User user) {
        this.accessToken = user.getAccessToken();
    }
}
