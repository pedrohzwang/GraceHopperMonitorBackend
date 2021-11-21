package com.gracehopper.gracehoppermonitorbackend.model;

import javax.persistence.*;

@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "nome_usuario", nullable = false, length = 20)
    private String username;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "token")
    private String accessToken;
}
