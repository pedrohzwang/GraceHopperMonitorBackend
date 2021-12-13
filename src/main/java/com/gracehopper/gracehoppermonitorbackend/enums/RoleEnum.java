package com.gracehopper.gracehoppermonitorbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoleEnum {

    DIRECTOR(1, "Diretor"),
    MANAGER(2, "Gestor"),
    COLLABORATOR(3, "Colaborador");

    @Getter
    private Integer id;
    @Getter
    private String description;

    public static RoleEnum valueOf(Integer id) {
        for (RoleEnum value : RoleEnum.values()) {
            if (value.getId() == id) return value;
        }

        throw new IllegalArgumentException("Invalid Role code!");
    }
}
