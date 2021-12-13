package com.gracehopper.gracehoppermonitorbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name = "usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer userId;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "nome_usuario", nullable = false, length = 20, unique = true)
    private String username;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "token")
    private String accessToken;

    @Column(name = "ds_cargo", length = 100, nullable = false)
    private String post;

    @ManyToOne
    @JoinColumn(name = "cd_funcao", nullable = false, referencedColumnName = "cd_funcao", foreignKey = @ForeignKey(name = "fk_funcao"))
    private Role userRole;

    @JsonProperty("userRole")
    private void unpackNested(Integer userRole) {
        this.userRole = new Role();
        this.userRole.setRoleId(userRole);
    }

}
