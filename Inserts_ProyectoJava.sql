select * from mascotas;
INSERT INTO mascotas (nombre, especie, raza, edad, fecha_nacimiento, sexo, microchip_tatuaje, foto, dueno_id) VALUES  
('Max', 'Perro', 'Labrador Retriever', 3, '2022-05-10', 'Macho', 'MICRO123456', 'foto_max.jpg', 1),  
('Luna', 'Gato', 'Siames', 2, '2023-02-20', 'Hembra', 'MICRO789012', 'foto_luna.jpg', 2),  
('Rocky', 'Perro', 'Bulldog Francés', 4, '2021-08-15', 'Macho', 'TATUAJE34567', 'foto_rocky.jpg', 3),  
('Milo', 'Gato', 'Maine Coon', 5, '2020-11-05', 'Macho', 'MICRO654321', 'foto_milo.jpg', 4),  
('Bella', 'Perro', 'Golden Retriever', 1, '2024-01-12', 'Hembra', 'TATUAJE98765', 'foto_bella.jpg', 5);

select * from duenos;
INSERT INTO duenos (id, nombre, cedula, direccion, telefono, correo_electronico, contacto_emergencia) VALUES
(1, 'Laura Sánchez', '2233445566', 'Calle B 234', '0976543211', 'laura@example.com', '0987234567'), 
(2, 'Juan Pérez', '1234567890', 'Calle A 123', '0987654321', 'juan@example.com', '0991122334'),  
(3, 'María López', '2345678901', 'Avenida B 456', '0998765432', 'maria@example.com', '0987654321'),  
(4, 'Carlos Gómez', '3456789012', 'Calle C 789', '0976543210', 'carlos@example.com', '0966788899'),  
(5, 'Ana Torres', '4567890123', 'Avenida D 321', '0965432109', 'ana@example.com', '0971122334');

select * from clientes_frecuentes;
INSERT INTO clientes_frecuentes (dueno_id, beneficio) VALUES  
(1, '10% de descuento en consultas médicas'),  
(2, 'Vacuna anual gratuita'),  
(3, 'Descuento en compra de medicamentos'),  
(4, 'Chequeo general gratuito cada 6 meses'),  
(5, 'Promoción en servicios de peluquería canina');

select * from veterinarios;
INSERT INTO veterinarios (nombre, especialidad, telefono, correo_electronico) VALUES  
('Dr. Juan Pérez', 'Medicina General', '3001234567', 'juan.perez@veterinaria.com'),  
('Dra. Ana Gómez', 'Cirugía', '3109876543', 'ana.gomez@veterinaria.com'),  
('Dr. Luis Rodríguez', 'Dermatología', '3204567891', 'luis.rodriguez@veterinaria.com'),  
('Dra. María Torres', 'Cardiología', '3157418529', 'maria.torres@veterinaria.com');

select * from citas_medicas;
INSERT INTO citas_medicas (fecha_hora, mascota_id, dueno_id, estado) VALUES
('2025-04-10', 2, 1, 'programada'),
('2025-04-15', 3, 2, 'programada'),
('2025-05-02', 4, 3, 'cancelada'),
('2025-05-10', 5, 4, 'programada'),
('2025-06-01', 6, 5, 'cancelada');

select * from proveedores;
-- DELETE FROM name_table WHERE id IN (1, 2, 3, 4, 5); Eliminacion de datos por id
INSERT INTO proveedores (id, nombre, contacto, direccion) VALUES  
(1, 'Distribuidora VetPlus', '0991122334', 'Avenida Central 123'),  
(2, 'Suministros PetHealth', '0976543210', 'Calle Comercial 456'),  
(3, 'Farmavet S.A.', '0965432109', 'Carrera 78 #12-34'),  
(4, 'MediTools Ltda.', '0987654321', 'Diagonal 55 #22-10'),  
(5, 'VetMeds Corp.', '0998765432', 'Zona Industrial 101');

select * from inventario;
INSERT INTO inventario (nombre, tipo, fabricante, cantidad_stock, fecha_vencimiento, proveedor_id) VALUE
('Vacuna Rabia', 'medicamento', 'VetPharm', 50, '2026-05-20', 3),
('Antiparasitario Canino', 'medicamento', 'PetHealth', 30, '2025-12-15', 2),
('Jeringas 10ml', 'insumo', 'MediTools', 200, NULL, 4),
('Algodón Estéril', 'insumo', 'CarePlus', 100, NULL, 1),
('Analgésico Felino', 'medicamento', 'VetMeds', 40, '2027-03-01', 5);

select * from historial_medico;
INSERT INTO historial_medico (mascota_id, fecha, motivo, diagnostico, observaciones, veterinario_id) VALUES  
(2, '2025-03-10', 'Vacunación anual', 'Sin anomalías detectadas', 'Se aplicó vacuna antirrábica', 2),  
(3, '2025-02-25', 'Revisión por falta de apetito', 'Leve infección estomacal', 'Se recetó dieta blanda y antibióticos', 3),  
(4, '2025-01-30', 'Herida en la pata', 'Corte superficial', 'Limpieza y vendaje, revisión en 5 días', 1),  
(5, '2024-12-15', 'Chequeo general', 'Buena salud', 'Se recomienda control anual', 4),  
(6, '2025-04-05', 'Dificultad para respirar', 'Principio de bronquitis', 'Tratamiento con nebulización', 2);

select * from consultas_medicas;
INSERT INTO consultas_medicas (fecha_hora, mascota_id, dueno_id, veterinario_id, estado, diagnostico, prescripcion_medica) VALUES  
('2025-04-10', 2, 1, 2, 'programada', 'Chequeo general', 'Ninguna prescripción necesaria'),  
('2025-04-15', 3, 2, 3, 'programada', 'Infección estomacal', 'Antibióticos y dieta blanda'),  
('2025-05-02', 4, 3, 1, 'cancelada', NULL, NULL),  
('2025-05-10', 5, 4, 4, 'programada', 'Vacunación anual', 'Aplicar vacuna antirrábica'),  
('2025-06-01', 6, 5, 2, 'finalizada', 'Bronquitis leve', 'Nebulización y reposo en casa');

select * from facturas;
INSERT INTO facturas (fecha, dueno_id, total, cufe, codigo_qr) VALUES
('2025-03-10', 1, 150.75, 'CUFE123ABC', 'https://example.com/qr1'),
('2025-03-15', 2, 250.50, 'CUFE456DEF', 'https://example.com/qr2'),
('2025-03-20', 3, 300.00, 'CUFE789GHI', 'https://example.com/qr3'),
('2025-03-25', 4, 175.25, 'CUFE101JKL', 'https://example.com/qr4'),
('2025-03-30', 5, 220.00, 'CUFE112MNO', 'https://example.com/qr5');

select * from detalles_factura;
INSERT INTO detalles_factura (factura_id, servicio_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 'Consulta médica', 1, 50.00, 50.00),
(1, 'Vacuna antirrábica', 1, 100.75, 100.75),
(2, 'Desparasitación', 1, 80.50, 80.50),
(2, 'Análisis de sangre', 1, 170.00, 170.00),
(3, 'Cirugía menor', 1, 300.00, 300.00),
(4, 'Baño y corte de pelo', 1, 75.25, 75.25),
(5, 'Consulta médica', 1, 50.00, 50.00),
(5, 'Tratamiento antibiótico', 1, 170.00, 170.00);

select * from facturas;
select * from inventario;
select *  from detalle_inventario_factura;
INSERT INTO detalle_inventario_factura (factura_id, inventario_id, cantidad, precio_unitario, subtotal) VALUES
(1, 19, 2, 25.50, 51.00),
(1, 17, 1, 100.00, 100.00),
(2, 21, 3, 40.75, 122.25),
(2, 18, 1, 75.50, 75.50),
(3, 22, 4, 20.00, 80.00);

select * from procedimientos_medicos;
INSERT INTO procedimientos_medicos (nombre, tipo, insumos_utilizados, mascota_id, veterinario_id, fecha, observaciones, inventario_id) VALUES
('Extracción de muela', 'Odontología', 'Anestesia, instrumental quirúrgico', 6, 2, '2025-03-20', 'Procedimiento realizado sin complicaciones', 19),
('Cirugía de esterilización', 'Cirugía', 'Sutura, anestesia, bisturí', 5, 1, '2025-02-10', 'Postoperatorio sin incidentes', 17),
('Limpieza de oídos', 'Cuidado preventivo', 'Solución limpiadora, gasas', 4, 3, '2025-01-25', 'Se recomienda repetir cada 3 meses', 16),
('Radiografía de cadera', 'Diagnóstico', 'Rayos X', 3, 4, '2025-04-05', 'Posibles signos de displasia leve', 18),
('Vacunación antirrábica', 'Vacunación', 'Vacuna antirrábica, jeringa', 2, 2, '2025-03-15', 'Siguiente refuerzo en un año', 20);

select * from tratamientos_antiparasitarios;
INSERT INTO tratamientos_antiparasitarios (tipo, fecha_aplicacion, fecha_proxima_dosis, mascota_id, inventario_id) VALUES
('Desparasitación interna', '2025-03-10', '2025-06-10', 6, 16),
('Desparasitación externa', '2025-02-25', '2025-05-25', 5, 17),
('Desparasitación mixta', '2025-01-30', '2025-04-30', 4, 18),
('Desparasitación interna', '2024-12-15', '2025-03-15', 3, 19),
('Desparasitación externa', '2025-04-05', '2025-07-05', 2, 20);

select * from vacunas;
INSERT INTO vacunas (id, nombre, fabricante, lote, fecha_aplicacion, fecha_vencimiento, mascota_id, inventario_id) VALUES 
(1, 'Vacuna Rabia', 'VetPharm', 'L12345', '2025-03-10', '2026-05-20', 3, 16),
(2, 'Antiparasitario Canino', 'PetHealth', 'P67890', '2025-02-20', '2025-12-15', 5, 17),
(3, 'MoquilloPlus', 'Bayer', 'M54321', '2025-01-15', '2026-01-15', 4, NULL),
(4, 'TripleFelina', 'Virbac', 'T98765', '2025-04-05', '2026-04-05', 2, NULL),
(5, 'LeptoVax', 'Boehringer', 'L24680', '2025-05-01', '2026-05-01', 6, NULL);

-- SERVICIOS MAS SOLICITADOS --
SELECT servicio_producto, COUNT(*) AS cantidad 
FROM detalles_factura GROUP BY servicio_producto 
ORDER BY cantidad DESC;

-- Mascotas atendidas: Número de visitas, procedimientos realizados, vacunas aplicadas
SELECT COUNT(*) AS total_visitas FROM citas_medicas;
SELECT COUNT(*) AS total_procedimientos FROM procedimientos_medicos;
SELECT COUNT(*) AS total_vacunas FROM vacunas;

-- Servicios más solicitados: Consultas médicas, cirugías, guardería, peluquería.
SELECT servicio_producto, COUNT(*) AS cantidad FROM detalles_factura 
WHERE servicio_producto IN ('Consulta Médica', 'Cirugía', 'Guardería', 'Peluquería')
GROUP BY servicio_producto ORDER BY cantidad DESC;

-- Desempeño del equipo veterinario: Cantidad de consultas atendidas por cada profesional.
select * from consultas_medicas;
SELECT v.nombre AS veterinario, COUNT(c.id) AS cantidad_consultas
FROM consultas_medicas c JOIN veterinarios v ON c.veterinario_id = v.id
GROUP BY v.nombre ORDER BY cantidad_consultas DESC;

-- Inventario: Medicamentos utilizados, próximos a vencer y necesidad de reabastecimiento.
select * from inventario;
SELECT id, nombre, tipo, cantidad_stock, fecha_vencimiento  FROM inventario WHERE tipo = 'medicamento';
SELECT id, nombre FROM inventario WHERE tipo = 'medicamento';

SELECT DISTINCT df.servicio_producto FROM detalles_factura df
WHERE df.servicio_producto NOT IN (SELECT DISTINCT nombre FROM inventario);

-- Facturación: Total facturado por período, servicios más rentables, clientes frecuentes.
select * from facturas;
SELECT f.fecha, SUM(df.subtotal) AS total_facturado
FROM facturas f JOIN detalles_factura df ON f.id = df.factura_id
GROUP BY f.fecha ORDER BY f.fecha DESC;

SELECT df.servicio_producto, SUM(df.subtotal) AS total_ingresos
FROM detalles_factura df GROUP BY df.servicio_producto 
ORDER BY total_ingresos DESC LIMIT 10;

SELECT d.nombre, d.cedula, COUNT(f.id) AS total_facturas, SUM(df.subtotal) AS total_gastado
FROM duenos d JOIN facturas f ON d.id = f.dueno_id JOIN detalles_factura df ON f.id = df.factura_id
GROUP BY d.id, d.nombre, d.cedula ORDER BY total_gastado DESC LIMIT 10;

-- ----------------------------------------------------------------------------------------------
SELECT cm.id, cm.fecha_hora, m.nombre AS mascota, d.nombre AS dueño, v.nombre 
AS veterinario, cm.estado, cm.diagnostico, cm.prescripcion_medica FROM consultas_medicas cm 
JOIN mascotas m ON cm.mascota_id = m.id JOIN duenos d ON cm.dueno_id = d.id 
JOIN veterinarios v ON cm.veterinario_id = v.id ORDER BY cm.fecha_hora DESC;

select * from procedimientos_medicos;
SELECT pm.id, pm.nombre, pm.tipo, pm.insumos_utilizados, m.nombre AS mascota, 
       v.nombre AS veterinario, pm.fecha, pm.observaciones, i.nombre AS insumo
FROM procedimientos_medicos pm
JOIN mascotas m ON pm.mascota_id = m.id
JOIN veterinarios v ON pm.veterinario_id = v.id
JOIN inventario i ON pm.inventario_id = i.id
ORDER BY pm.fecha DESC;