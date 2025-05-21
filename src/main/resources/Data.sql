CREATE DATABASE inscripciones_db;
-- 1. Crear la tabla 'cupones'
CREATE TABLE cupones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    porcentajeDescuento DECIMAL(5,2) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- 2. Crear la tabla 'inscripciones'
CREATE TABLE inscripciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idCurso INT NOT NULL,
    idEstudiante INT NOT NULL,
    fechaInscripcion DATE NOT NULL,
    montoPagado DECIMAL(10,2) NOT NULL,
    cupon_id INT,
    finalizado BOOLEAN NOT NULL DEFAULT false,
    progreso DECIMAL(5,2) NOT NULL DEFAULT 0.0,
    FOREIGN KEY (cupon_id) REFERENCES cupones(id)
);

-- 3. Insertar datos en 'cupones'
INSERT INTO cupones (codigo, porcentajeDescuento, activo) VALUES
('DESC10', 10.0, true),
('DESC20', 20.0, true),
('INACTIVO5', 5.0, false);

-- 4. Insertar datos en 'inscripciones'
INSERT INTO inscripciones (idCurso, idEstudiante, fechaInscripcion, montoPagado, cupon_id, finalizado, progreso) VALUES
(1, 1001, CURDATE(), 900.00, 1, false, 0.0),
(2, 1002, CURDATE(), 800.00, 2, false, 0.0),
(3, 1003, CURDATE(), 1000.00, NULL, false, 0.0);
Notas importantes:
Relación entre tablas: La tabla inscripciones tiene una clave foránea (cupon_id) que referencia a la tabla cupones. Esto significa que:
Los valores de cupon_id en inscripciones deben existir en la columna id de cupones.
El valor NULL en cupon_id (como en la tercera inscripción) significa que no se aplicó ningún cupón.
Tipos de datos:
porcentajeDescuento y progreso usan DECIMAL para precisión en valores decimales.
activo y finalizado son booleanos (true/false).
Ejecución:
Si estás usando MySQL desde la terminal, ejecuta este script con:
bash
mysql -u tu_usuario -p usuario_db < script.sql
Si usas MySQL Workbench o phpMyAdmin, copia y pega el script completo.

Verificación:

Para comprobar que los datos se insertaron correctamente
SELECT * FROM cupones;
SELECT * FROM inscripciones;