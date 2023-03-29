/*
    !Creación de la base de datos
*/
CREATE DATABASE electronichomes;

\c electronichomes;

CREATE EXTENSION pgcrypto;

CREATE SCHEMA ControlVentas;
CREATE SCHEMA ControlUsuarios;
CREATE SCHEMA ControlSucursal;


CREATE TABLE ControlUsuarios.Cliente(
    nit VARCHAR( 8 ) NOT NULL,
    nombre VARCHAR( 100 ),
    direccion VARCHAR( 100 ),
    PRIMARY KEY( nit )
);

CREATE TABLE ControlSucursal.Sucursal(
    id_sucursal SERIAL,
    nombre VARCHAR( 100 ) NOT NULL,
    PRIMARY KEY( id_sucursal )
);

CREATE TABLE ControlUsuarios.Empleado(
    username VARCHAR( 45 ) NOT NULL,
    contrasenia CHAR( 60 ) NOT NULL,
    rol INT NOT NULL,
    id_sucursal INT NOT NULL,
    PRIMARY KEY ( username ),
    FOREIGN KEY ( id_sucursal ) REFERENCES ControlSucursal.Sucursal( id_sucursal )
);

CREATE TABLE ControlVentas.Venta(
    id_venta SERIAL NOT NULL,
    total FLOAT NOT NULL,
    nit VARCHAR( 8 ) NOT NULL,
    username VARCHAR( 45 ) NOT NULL,
    PRIMARY KEY ( id_venta ),
    FOREIGN KEY ( nit ) REFERENCES ControlUsuarios.Cliente( nit ),
    FOREIGN KEY ( username ) REFERENCES ControlUsuarios.Empleado( username )
);

CREATE TABLE ControlSucursal.Electrodomestico(
    id_electrodomestico SERIAL NOT NULL,
    nombre VARCHAR( 45 ) NOT NULL,
    precio FLOAT NOT NULL,
    PRIMARY KEY ( id_electrodomestico )
);

CREATE TABLE ControlSucursal.Inventario(
    id_inventario SERIAL NOT NULL,
    existencia INT NOT NULL,
    id_sucursal INT NOT NULL,
    id_electrodomestico INT NOT NULL,
    estado INT NOT NULL,
    PRIMARY KEY ( id_inventario ),
    FOREIGN KEY ( id_sucursal ) REFERENCES ControlSucursal.Sucursal( id_sucursal ),
    FOREIGN KEY ( id_electrodomestico ) REFERENCES ControlSucursal.Electrodomestico( id_electrodomestico )
);

CREATE TABLE ControlVentas.DetalleVenta(
    id_detalle_venta SERIAL NOT NULL,
    precio FLOAT NOT NULL,
    cantidad INT NOT NULL,
    id_venta INT NOT NULL,
    id_inventario INT NOT NULL,
    PRIMARY KEY( id_detalle_venta ),
    FOREIGN KEY( id_venta ) REFERENCES ControlVentas.Venta( id_venta ),
    FOREIGN KEY( id_inventario ) REFERENCES ControlSucursal.Inventario( id_inventario )
);


/*
    *INSERTS de sucursales al sistema de base de datos
*/

INSERT INTO ControlSucursal.Sucursal ( nombre ) VALUES
                        ('Sucursal Central'),
                        ('Sucursal Norte'),
                        ('Sucursal Sur'),
                        ('Bodega'),
                        ('Admin');

/*
    !QUERYS para el administrador
*/

SELECT e.id_electrodomestico AS id, e.nombre AS nombre, e.precio AS precio, i.existencia AS existencia FROM ControlSucursal.Electrodomestico AS e INNER JOIN ControlSucursal.Inventario AS i ON e.id_electrodomestico = i.id_electrodomestico WHERE i.id_sucursal = 4 AND i.estado = 1 AND i.existencia > 0 ORDER BY e.id_electrodomestico ASC;