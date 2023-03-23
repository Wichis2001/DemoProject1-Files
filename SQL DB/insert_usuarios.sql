\c electronic-homes;

/*
    !Clientes generales del sistema
*/
INSERT INTO ControlUsuarios.Cliente VALUES
                ("41189121","Kyle Mcneil","Tehuacán"),
                ("73463658","Mia Navarro","Acapulco"),
                ("72700249","Lance Wong","Tehuacán"),
                ("17306477","Gemma Gordon","Ciudad Valles"),
                ("57805183","Caldwell Walters","Culiacán"),
                ("58173089","Lewis Reyes","Saltillo"),
                ("42002003","Ramona Alexander","Irapuato"),
                ("72619597","Dale Browning","Oaxaca");

/*
    ?Usuarios para acceso al sistema
*/
/*
    *Sucursal 1
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ("lucas01", "1234", 1, 1),
                ("lucas02", "1234", 1, 1),
                ("lucas03", "1234", 1, 1),
                ("marcos01", "1234", 2, 1);
/*
    *Sucursal 2
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ("luis01", "1234", 1, 2),
                ("luis02", "1234", 1, 2),
                ("luis03", "1234", 1, 2),
                ("marcos02", "1234", 2, 2);
/*
    *Sucursal 3
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ("ricardo01", "1234", 1, 3),
                ("ricardo02", "1234", 1, 3),
                ("ricardo03", "1234", 1, 3),
                ("marcos03", "1234", 2, 3);
/*
    *Roles Generales
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ("vinicio01", "1234", 3, 4),
                ("vinicio02", "1234", 3, 4),
                ("vinicio03", "1234", 3, 4),
                ("vinicio04", "1234", 3, 4);
                ("admin01","1234",4,5);