/*
    !Clientes generales del sistema
*/
INSERT INTO ControlUsuarios.Cliente VALUES
                ('C/F'),
                ('41189121','Kyle Mcneil','Tehuacan'),
                ('73463658','Mia Navarro','Acapulco'),
                ('72700249','Lance Wong','Tehuacan'),
                ('17306477','Gemma Gordon','Ciudad Valles'),
                ('57805183','Caldwell Walters','Culiacan'),
                ('58173089','Lewis Reyes','Saltillo'),
                ('42002003','Ramona Alexander','Irapuato'),
                ('72619597','Dale Browning','Oaxaca');

/*
    ?Usuarios para acceso al sistema
*/
/*
    *Sucursal 1
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ('lucas01', crypt('1234', gen_salt('bf')), 1, 1),
                ('lucas02', crypt('5678', gen_salt('bf')), 1, 1),
                ('lucas03', crypt('9101', gen_salt('bf')), 1, 1),
                ('marcos01',crypt('1223', gen_salt('bf')), 2, 1);
/*
    *Sucursal 2
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ('luis01', crypt('4567', gen_salt('bf')), 1, 2),
                ('luis02', crypt('8921', gen_salt('bf')), 1, 2),
                ('luis03', crypt('2324', gen_salt('bf')), 1, 2),
                ('marcos02',crypt('8978', gen_salt('bf')), 2, 2);
/*
    *Sucursal 3
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ('ricardo01', crypt('2526', gen_salt('bf')), 1, 3),
                ('ricardo02', crypt('2728', gen_salt('bf')), 1, 3),
                ('ricardo03', crypt('2930', gen_salt('bf')), 1, 3),
                ('marcos03', crypt('3132', gen_salt('bf')), 2, 3);
/*
    *Roles Generales
*/
INSERT INTO ControlUsuarios.Empleado VALUES
                ('vinicio01', crypt('3334', gen_salt('bf')), 3, 4),
                ('vinicio02', crypt('3536', gen_salt('bf')), 3, 4),
                ('vinicio03', crypt('3738', gen_salt('bf')), 3, 4),
                ('vinicio04', crypt('3940', gen_salt('bf')), 3, 4),
                ('admin01', crypt('4142', gen_salt('bf')), 4, 5);


SELECT * FROM ControlSucursal.Electrodomestico WHERE nombre = '' LIMIT 1;
