package com.gracehopper.gracehoppermonitorbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "log")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Log implements Serializable {

    @Id
    @Column(name = "cd_log")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logCode;

    @Column(name = "conteudo", nullable = false)
    private String content;

    @Column(name = "dt_log", nullable = false)
    private LocalDateTime logDate;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, referencedColumnName = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario_id"))
    private User userId;

    @JsonProperty("userId")
    private void unpackNested(Long userId) {
        this.userId = new User();
        this.userId.setUserId(userId);
    }
}
