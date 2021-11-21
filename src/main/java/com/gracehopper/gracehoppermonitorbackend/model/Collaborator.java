package com.gracehopper.gracehoppermonitorbackend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "colaborador")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private Long collaboratorId;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "ds_cargo", length = 100, nullable = false)
    private String post;

    @ManyToOne
    @JoinColumn(name = "cd_funcao", nullable = false, referencedColumnName = "cd_funcao", foreignKey = @ForeignKey(name = "fk_funcao"))
    private Role collaboratorRole;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false, referencedColumnName = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario"))
    private User userId;

}
