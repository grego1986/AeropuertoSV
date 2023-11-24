use aeropuerto_sv;

-- Insertar datos en la tabla `aviones`
INSERT INTO `aeropuerto_sv`.`aviones` (`id`, `columna`, `fila`) VALUES
    (1, 4, 25),
    (2, 4, 30),
    (3, 5, 28),
    (4, 6, 32),
    (5, 3, 20);

-- Insertar datos en la tabla `asientos_aviones`
INSERT INTO `aeropuerto_sv`.`asientos_aviones` (`numero_asiento`, `disponible`, `avion_id`) VALUES
    ('A1', 1, 1),
    ('B3', 1, 1),
    ('C5', 1, 2),
    ('D2', 0, 3),
    ('E10', 1, 5);

-- Insertar datos en la tabla `clientes`
INSERT INTO `aeropuerto_sv`.`clientes` (`apellido`, `nombre`, `domicilio`, `nacimiento`, `mail`) VALUES
    ('González', 'Juan', 'Calle 123', '1990-05-15', 'juan@gmail.com'),
    ('López', 'María', 'Av. Principal', '1985-08-20', 'maria@hotmail.com'),
    ('Martínez', 'Carlos', 'Calle 456', '1992-01-10', 'carlos@yahoo.com'),
    ('Rodríguez', 'Ana', 'Av. Secundaria', '1988-11-05', 'ana@gmail.com'),
    ('Pérez', 'Luis', 'Calle 789', '1995-03-25', 'luis@hotmail.com');

    -- Insertar datos en la tabla `ciudades`
INSERT INTO `aeropuerto_sv`.`ciudades` (`nombre`) VALUES
    ('Sauce Viejo'),
    ('Rosario'),
    ('Buenos Aires'),
    ('Cordoba'),
    ('Lima'),
    ('New York');

-- Insertar datos en la tabla `vuelos`
INSERT INTO `aeropuerto_sv`.`vuelos` (`ciudad_destino`, `estado`, `fecha`, `hora`, `nro_vuelo`, `ciudad_origen`) VALUES
    (2, 'Normal', '2023-12-01', '12:30:00', 'SV123', 1),
    (3, 'Normal', '2023-11-25', '15:45:00', 'SV456', 1),
    (4, 'Reprogramado', '2023-11-20', '08:00:00', 'SV789', 1),
    (5, 'Cancelado', '2023-12-10', '10:15:00', 'SV101', 1),
    (6, 'normal', '2023-12-05', '18:20:00', 'SV202', 1);

-- Insertar datos en la tabla `internacionales`
INSERT INTO `aeropuerto_sv`.`internacionales` (`precio`, `tasa`, `id_vuelo`) VALUES
    (500.00, 50.00, 4),
    (700.00, 60.00, 5);
   
-- Insertar datos en la tabla `nacionales`
INSERT INTO `aeropuerto_sv`.`nacionales` (`precio`, `tasa`, `id_vuelo`) VALUES
    (300.00, 30.00, 1),
    (400.00, 35.00, 2),
    (350.00, 32.00, 3);

-- Insertar datos en la tabla `pasajes`
INSERT INTO `aeropuerto_sv`.`pasajes` (`precio_total`, `cliente_id`, `vuelo_id`) VALUES
    (330.00, 1,1),
    (400.00, 2, 2),
    (350.00, 3, 3);
    
    -- Insertar datos en la tabla `pasaportes`
INSERT INTO `aeropuerto_sv`.`pasaportes` (`expiracion`, `n_pasaporte`, `cliente_id`) VALUES
    ('2025-01-10', 'ad125112544d', 4),
    ('2024-01-10', 'jjnh23522614', 5);
    
    