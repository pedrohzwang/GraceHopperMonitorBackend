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

    @Column(nullable = false, length = 255, name = "conteudo")
    private String content;

    @Column(nullable = false, name = "dt_log")
    private LocalDate logDate;
}
