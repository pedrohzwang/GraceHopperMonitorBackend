CREATE TABLE funcao (
    cdFuncao INTEGER NOT NULL AUTO INCREMENT,
    dsFuncao VARCHAR(255) NOT NULL,
    PRIMARY KEY (cdFuncao)
);

CREATE TABLE usuario (
    idUsuario BIGINT NOT NULL AUTO INCREMENT,
    nome VARCHAR(255) NOT NULL, 
    cargo VARCHAR(50) NOT NULL,
    cdFuncao INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cdFuncao) REFERENCES funcao (cdFuncao)
);

CREATE TABLE log (
    cdLog BIGINT NOT NULL AUTO INCREMENT,
    conteudo VARCHAR(255) NOT NULL,
    dtLog DATETIME NOT NULL
    PRIMARY KEY (cdLog)
);

CREATE TABLE usuario_log (
    idUsuario BIGINT NOT NULL,
    cdLog BIGINT NOT NULL,
    PRIMARY KEY (idUsuario),
    FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
    FOREIGN KEY (cdLog) REFERENCES log (cdLog)
);

