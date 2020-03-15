DROP TABLE IF EXISTS cidade;
DROP TABLE IF EXISTS estado;

CREATE TABLE estado (
                       id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                       nome varchar(100),
                       cod_nome varchar(50),
                       img_nome varchar(100),
                       PRIMARY KEY (id),
                       UNIQUE (nome)
);

CREATE TABLE cidade (
                         id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                         nome varchar(150) NOT NULL,
                         estado_id BIGINT,
                         PRIMARY KEY (id),
                         FOREIGN KEY (estado_id) REFERENCES estado(id) ON DELETE CASCADE
);


INSERT INTO estado(nome, cod_nome, img_nome) VALUES
('Amazonas', 'am', 'bandeiraAM'),
('Rio Grande do Sul', 'rs', 'bandeiraRS'),
('Santa Catarina', 'sc', 'bandeiraSC'),
('Paraná', 'pn', 'bandeiraPN');

INSERT INTO cidade(nome) VALUES
('Manaus'),
('Manacapuru'),
('Itacoatiara');
