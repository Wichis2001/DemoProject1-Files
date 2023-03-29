/*
    !Ventas para la Sucursal 1
*/
INSERT INTO ControlVentas.Venta ( total, nit, username ) VALUES
                        (1947.06, '41189121', 'lucas01'),
                        (1822.56, '41189121', 'lucas01'),
                        (5486.64, '57805183', 'lucas02'),
                        (6723.92, '42002003', 'lucas01'),
                        (5000.00, '42002003', 'lucas01');


INSERT INTO ControlVentas.DetalleVenta ( precio, cantidad, id_venta, id_inventario ) VALUES
                        (1946.06, 2, 1, 1),
                        (1822.56, 4, 2, 2),
                        (5486.64, 6, 3, 3),
                        (6723.92, 8, 4, 4),
                        (3786.60,10, 5, 5);


/*
    ?Ventas para la Sucursal 2
*/
INSERT INTO ControlVentas.Venta ( total, nit, username ) VALUES
                        (789.44, '58173089', 'luis01'),
                        (1800.00, '72700249', 'luis01'),
                        (592.92, '57805183', 'luis02'),
                        (715.36, '58173089', 'luis02'),
                        (1731.20, '42002003', 'luis03');


INSERT INTO ControlVentas.DetalleVenta ( precio, cantidad, id_venta, id_inventario ) VALUES
                        (789.44,2, 6, 31),
                        (1800.00, 4, 7, 32),
                        (592.92, 6, 8, 33),
                        (715.36, 4, 9, 34),
                        (1731.20, 2, 10, 35);


/*
    *Ventas para la Sucursal 3
*/
INSERT INTO ControlVentas.Venta ( total, nit, username ) VALUES
                        (9216.00, '57805183', 'ricardo02'),
                        (3955.20, '17306477', 'ricardo01'),
                        (820.80, '58173089', 'ricardo02'),
                        (3262.08, '17306477', 'ricardo03'),
                        (1086.74, '57805183', 'ricardo02');


INSERT INTO ControlVentas.DetalleVenta ( precio, cantidad, id_venta, id_inventario ) VALUES
                        (9216.00, 10, 11, 56),
                        (3955.20, 8, 12, 57),
                        (820.80, 6, 13, 58),
                        (3262.08, 4, 14, 59),
                        (1086.74, 2, 15, 60);