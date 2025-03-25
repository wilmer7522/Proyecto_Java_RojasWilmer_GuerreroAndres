CREATE TABLE IF NOT EXISTS duenos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    direccion TEXT,
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    contacto_emergencia VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS veterinarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS proveedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    direccion TEXT
);

CREATE TABLE IF NOT EXISTS inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) CHECK (tipo IN ('medicamento', 'insumo')),
    fabricante VARCHAR(100),
    cantidad_stock INT NOT NULL CHECK (cantidad_stock >= 0),
    fecha_vencimiento DATE,
    proveedor_id INT,
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS mascotas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    edad INT,
    fecha_nacimiento VARCHAR(20),
    sexo VARCHAR(10),
    microchip_tatuaje VARCHAR(50),
    foto TEXT,
    dueno_id INT,
    FOREIGN KEY (dueno_id) REFERENCES duenos(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS historial_medico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mascota_id INT NOT NULL,
    fecha DATE NOT NULL,
    motivo TEXT NOT NULL,
    diagnostico TEXT,
    observaciones TEXT,
    veterinario_id INT NOT NULL,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (veterinario_id) REFERENCES veterinarios(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS vacunas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    lote VARCHAR(50),
    fecha_aplicacion DATE NOT NULL,
    fecha_vencimiento DATE,
    mascota_id INT NOT NULL,
    inventario_id INT,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (inventario_id) REFERENCES inventario(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS tratamientos_antiparasitarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    fecha_aplicacion DATE NOT NULL,
    fecha_proxima_dosis DATE,
    mascota_id INT NOT NULL,
    inventario_id INT,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (inventario_id) REFERENCES inventario(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS consultas_medicas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora TIMESTAMP NOT NULL,
    mascota_id INT NOT NULL,
    dueno_id INT NOT NULL,
    veterinario_id INT NOT NULL,
    estado VARCHAR(20) CHECK (estado IN ('programada', 'en proceso', 'finalizada', 'cancelada')),
    diagnostico TEXT,
    prescripcion_medica TEXT,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (dueno_id) REFERENCES duenos(id) ON DELETE CASCADE,
    FOREIGN KEY (veterinario_id) REFERENCES veterinarios(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS procedimientos_medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    insumos_utilizados TEXT,
    mascota_id INT NOT NULL,
    veterinario_id INT NOT NULL,
    fecha DATE NOT NULL,
    observaciones TEXT,
    inventario_id INT,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (veterinario_id) REFERENCES veterinarios(id) ON DELETE CASCADE,
    FOREIGN KEY (inventario_id) REFERENCES inventario(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS citas_medicas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora TIMESTAMP NOT NULL,
    mascota_id INT NOT NULL,
    dueno_id INT NOT NULL,
    estado VARCHAR(20) CHECK (estado IN ('programada', 'cancelada')),
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (dueno_id) REFERENCES duenos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    dueno_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    cufe VARCHAR(100),
    codigo_qr TEXT,
    FOREIGN KEY (dueno_id) REFERENCES duenos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS detalles_factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    factura_id INT NOT NULL,
    servicio_producto VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (factura_id) REFERENCES facturas(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS detalle_inventario_factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    factura_id INT NOT NULL,
    inventario_id INT NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (factura_id) REFERENCES facturas(id) ON DELETE CASCADE,
    FOREIGN KEY (inventario_id) REFERENCES inventario(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS adopciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mascota_id INT NOT NULL,
    nuevo_dueno_id INT NOT NULL,
    fecha DATE NOT NULL,
    seguimiento TEXT,
    FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
    FOREIGN KEY (nuevo_dueno_id) REFERENCES duenos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS clientes_frecuentes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dueno_id INT NOT NULL,
    beneficio TEXT,
    FOREIGN KEY (dueno_id) REFERENCES duenos(id) ON DELETE CASCADE
);

