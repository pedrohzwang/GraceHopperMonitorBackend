package com.gracehopper.gracehoppermonitorbackend.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {

    DIRECTOR(1, "Diretor"),
    MANAGER(2, "Gestor"),
    COLLABORATOR(3, "Colaborador");

    private Integer id;
    private String description;
}
