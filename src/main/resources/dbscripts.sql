CREATE TABLE funcao (
    cd_funcao INTEGER NOT NULL AUTO INCREMENT,
    ds_funcao VARCHAR(255) NOT NULL,
    PRIMARY KEY (cd_funcao)
);

CREATE TABLE usuario (
    id_usuario BIGINT NOT NULL AUTO INCREMENT,
    nome VARCHAR(255) NOT NULL, 
    cargo VARCHAR(50) NOT NULL,
    cd_funcao INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cd_funcao) REFERENCES funcao (cd_funcao)
);

CREATE TABLE log (
    cd_log BIGINT NOT NULL AUTO INCREMENT,
    conteudo VARCHAR(255) NOT NULL,
    dt_log DATETIME NOT NULL
    PRIMARY KEY (cd_log)
);

CREATE TABLE usuario_log (
    id_usuario BIGINT NOT NULL,
    cd_log BIGINT NOT NULL,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (cd_log) REFERENCES log (cd_log)
);

