--/* Populate tables */
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES(1, 'Divier', 'Casas', 'profesor@bolsadeideas.com', '01/01/2010', '');

--
--/* Populate tabla productos */
INSERT INTO productos (id, nombre, precio, create_at) VALUES(1, 'Panasonic Pantalla LCD', 259990, sysdate);

--
--/* Creamos algunas facturas */
--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);
--
--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);