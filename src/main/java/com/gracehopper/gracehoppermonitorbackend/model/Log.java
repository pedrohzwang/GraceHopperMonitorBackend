package com.gracehopper.gracehoppermonitorbackend.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "log")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Log {

    @Id
    @Column(name = "cd_log")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logCode;

    @Column(name = "conteudo", nullable = false)
    private String content;

    @Column(name = "dt_log", nullable = false)
    private LocalDate logDate;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, referencedColumnName = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario_id"))
    private User userId;
}
