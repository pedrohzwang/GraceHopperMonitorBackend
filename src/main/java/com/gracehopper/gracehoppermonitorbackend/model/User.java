package com.gracehopper.gracehoppermonitorbackend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "usuario")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long userId;

    @Column(nullable = false, length = 255, name = "nome")
    private String name;

    @Column(nullable = false, length = 100, name = "ds_cargo")
    private String post;

    @ManyToOne
    @JoinColumn(name = "cd_funcao", nullable = false, referencedColumnName = "cd_funcao", foreignKey = @ForeignKey(name = "fk_funcao"))
    private Role userRole;

}
