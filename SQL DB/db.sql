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

SELECT e.nombre as electrodomestico, SUM(dv.cantidad) as total_vendido FROM ControlVentas.DetalleVenta dv INNER JOIN ControlSucursal.Inventario i ON dv.id_inventario = i.id_inventario INNER JOIN ControlSucursal.Electrodomestico e ON i.id_electrodomestico = e.id_electrodomestico GROUP BY i.id_inventario, e.nombre ORDER BY total_vendido DESC LIMIT 10;

SELECT c.nombre as cliente, SUM(v.total) as total_ventas FROM ControlUsuarios.Cliente c INNER JOIN ControlVentas.Venta v ON c.nit = v.nit GROUP BY c.nit, c.nombre ORDER BY total_ventas DESC LIMIT 10;

SELECT s.nombre as sucursal, COUNT(v.total) as total_ventas FROM ControlSucursal.Sucursal s INNER JOIN ControlUsuarios.Empleado e ON s.id_sucursal = e.id_sucursal INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY s.id_sucursal, s.nombre ORDER BY total_ventas DESC LIMIT 3;

SELECT s.nombre as sucursal, SUM(v.total) as total_ventas FROM ControlSucursal.Sucursal s INNER JOIN ControlUsuarios.Empleado e ON s.id_sucursal = e.id_sucursal INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY s.id_sucursal, s.nombre ORDER BY total_ventas DESC LIMIT 3;

SELECT e.username as empleado, COUNT(*) as total_ventas FROM ControlUsuarios.Empleado e INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY e.username ORDER BY total_ventas DESC LIMIT 3;

SELECT e.username as empleado, SUM(v.total) as total_ventas FROM ControlUsuarios.Empleado e INNER JOIN ControlVentas.Venta v ON e.username = v.username GROUP BY e.username ORDER BY total_ventas DESC LIMIT 3;

SELECT e.nombre as producto, SUM(dv.precio) as total_ingresos FROM ControlSucursal.Electrodomestico e INNER JOIN ControlSucursal.Inventario i ON e.id_electrodomestico = i.id_electrodomestico INNER JOIN ControlVentas.DetalleVenta dv ON i.id_inventario = dv.id_inventario GROUP BY e.id_electrodomestico, e.nombre ORDER BY total_ingresos DESC LIMIT 10;

SELECT e.nombre as producto, SUM(dv.cantidad) as total_vendido FROM ControlVentas.DetalleVenta dv INNER JOIN ControlVentas.Venta v ON dv.id_venta = v.id_venta INNER JOIN ControlSucursal.Inventario inv ON dv.id_inventario = inv.id_inventario INNER JOIN ControlSucursal.Electrodomestico e ON inv.id_electrodomestico = e.id_electrodomestico WHERE inv.id_sucursal = 1 GROUP BY inv.id_electrodomestico, e.nombre ORDER BY total_vendido DESC LIMIT 5;

SELECT e.nombre as producto, SUM(dv.precio) as total_vendido FROM ControlVentas.DetalleVenta dv INNER JOIN ControlVentas.Venta v ON dv.id_venta = v.id_venta INNER JOIN ControlSucursal.Inventario inv ON dv.id_inventario = inv.id_inventario INNER JOIN ControlSucursal.Electrodomestico e ON inv.id_electrodomestico = e.id_electrodomestico WHERE inv.id_sucursal = 1 GROUP BY inv.id_electrodomestico, e.nombre ORDER BY total_vendido DESC LIMIT 5;