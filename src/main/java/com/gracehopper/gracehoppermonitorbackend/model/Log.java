package com.gracehopper.gracehoppermonitorbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "log")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String logDate;
}
