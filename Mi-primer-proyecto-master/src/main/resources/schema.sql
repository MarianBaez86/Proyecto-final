DROP TABLE IF EXISTS ITEMS_COMPROBANTE;
DROP TABLE IF EXISTS COMPROBANTE;
DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE IF NOT EXISTS CLIENTE
(
    nombre   VARCHAR(50),
    apellido VARCHAR(50),
    dni      INT NOT NULL,
    FECHA_DE_NACIMIENTO  DATE,
    primary key (dni)

);

CREATE TABLE IF NOT EXISTS PRODUCTO
(
    id  INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50),
    precio      DECIMAL (20),
    activo BOOLEAN,
    fecha_creacion DATE,
    fecha_actualizacion DATE,
    stock INT,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS COMPROBANTE
(
    id   INT NOT NULL AUTO_INCREMENT,
    dni_cliente INT,
    fecha_creacion DATE,
    primary key (id),
    foreign key (dni_cliente) references CLIENTE (dni)
);

CREATE TABLE IF NOT EXISTS ITEMS_COMPROBANTE
(
    id   INT NOT NULL AUTO_INCREMENT,
    id_comprobante INT,
    detalle VARCHAR(50),
    precio      DECIMAL (20),
    precio_unitario      DECIMAL (20),
    cantidad INT,
    primary key (id),
    foreign key (id_comprobante) references COMPROBANTE (id)
);