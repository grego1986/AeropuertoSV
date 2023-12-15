CREATE DATABASE IF NOT EXISTS  aeropuerto_SV;
USE aeropuerto_SV;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema aeropuerto_sv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aeropuerto_sv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aeropuerto_sv` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `aeropuerto_sv` ;

-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`aviones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`aviones` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `columna` INT NULL DEFAULT NULL,
  `fila` INT NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`asientos_aviones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`asientos_aviones` (
  `id` VARCHAR(255) NOT NULL,
  `disponible` BIT(1) NULL DEFAULT NULL,
  `avion_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKqhjyd1s4si5kudxx9yu3jtr3` (`avion_id` ASC),
  CONSTRAINT `FKqhjyd1s4si5kudxx9yu3jtr3`
    FOREIGN KEY (`avion_id`)
    REFERENCES `aeropuerto_sv`.`aviones` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`pais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`ciudades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `pais_ciudad` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKrrjunoksjbslt9cmcyqxxxqnh` (`pais_ciudad` ASC),
  CONSTRAINT `FKrrjunoksjbslt9cmcyqxxxqnh`
    FOREIGN KEY (`pais_ciudad`)
    REFERENCES `aeropuerto_sv`.`pais` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`clientes` (
  `dni` BIGINT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `domicilio` VARCHAR(255) NULL DEFAULT NULL,
  `nacimiento` DATE NULL DEFAULT NULL,
  `mail` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`vuelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`vuelos` (
  `n_vuelo` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `hora` TIME NULL DEFAULT NULL,
  `avion_asignado` BIGINT NULL DEFAULT NULL,
  `ciudad_destino` INT NULL DEFAULT NULL,
  `ciudad_origen` INT NULL DEFAULT NULL,
  PRIMARY KEY (`n_vuelo`),
  INDEX `FKirk1kyhpnneccfm851408q0tp` (`avion_asignado` ASC),
  INDEX `FK4sv51m9yjrxs4nqqropq158xa` (`ciudad_destino` ASC),
  INDEX `FK1ax28yasqhf9v3e0lnolxasl5` (`ciudad_origen` ASC),
  CONSTRAINT `FK1ax28yasqhf9v3e0lnolxasl5`
    FOREIGN KEY (`ciudad_origen`)
    REFERENCES `aeropuerto_sv`.`ciudades` (`id`),
  CONSTRAINT `FK4sv51m9yjrxs4nqqropq158xa`
    FOREIGN KEY (`ciudad_destino`)
    REFERENCES `aeropuerto_sv`.`ciudades` (`id`),
  CONSTRAINT `FKirk1kyhpnneccfm851408q0tp`
    FOREIGN KEY (`avion_asignado`)
    REFERENCES `aeropuerto_sv`.`aviones` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`tasa_internacional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`tasa_internacional` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dolar` DOUBLE NULL DEFAULT NULL,
  `iva` DOUBLE NULL DEFAULT NULL,
  `tasa` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`internacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`internacionales` (
  `precio` DOUBLE NULL DEFAULT NULL,
  `n_vuelo` VARCHAR(255) NOT NULL,
  `id_tasa` INT NULL DEFAULT NULL,
  PRIMARY KEY (`n_vuelo`),
  INDEX `FKse5kb73fj7n48c5g89d3sqdw9` (`id_tasa` ASC),
  CONSTRAINT `FKi913ksnra9ant6f6k45pix93i`
    FOREIGN KEY (`n_vuelo`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`n_vuelo`),
  CONSTRAINT `FKse5kb73fj7n48c5g89d3sqdw9`
    FOREIGN KEY (`id_tasa`)
    REFERENCES `aeropuerto_sv`.`tasa_internacional` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`tasa_nacional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`tasa_nacional` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `iva` DOUBLE NULL DEFAULT NULL,
  `precio` DOUBLE NULL DEFAULT NULL,
  `tasa` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`nacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`nacionales` (
  `precio` DOUBLE NULL DEFAULT NULL,
  `n_vuelo` VARCHAR(255) NOT NULL,
  `id_tasa` INT NULL DEFAULT NULL,
  PRIMARY KEY (`n_vuelo`),
  INDEX `FKyo25bcnd6apcmn77760jck3j` (`id_tasa` ASC),
  CONSTRAINT `FK74b61oe6749vonk9pf0kt6ae4`
    FOREIGN KEY (`n_vuelo`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`n_vuelo`),
  CONSTRAINT `FKyo25bcnd6apcmn77760jck3j`
    FOREIGN KEY (`id_tasa`)
    REFERENCES `aeropuerto_sv`.`tasa_nacional` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`pasajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`pasajes` (
  `id_pasaje` BIGINT NOT NULL AUTO_INCREMENT,
  `precio_total` DOUBLE NULL DEFAULT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  `vuelo_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pasaje`),
  INDEX `FK7p44jddxs6fpkc3b1uo38528` (`cliente_id` ASC),
  INDEX `FK83k3kj099oxb7r8bovhfpu9og` (`vuelo_id` ASC),
  CONSTRAINT `FK7p44jddxs6fpkc3b1uo38528`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `aeropuerto_sv`.`clientes` (`dni`),
  CONSTRAINT `FK83k3kj099oxb7r8bovhfpu9og`
    FOREIGN KEY (`vuelo_id`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`n_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`pasaportes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`pasaportes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `expiracion` DATE NULL DEFAULT NULL,
  `n_pasaporte` VARCHAR(255) NULL DEFAULT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ee6mbqa99sxe3iy3v5tfjns9b` (`cliente_id` ASC),
  CONSTRAINT `FKeg5m470dgua7bw8rv5leag1b3`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `aeropuerto_sv`.`clientes` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`tickets` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  `pasaje_id` BIGINT NULL DEFAULT NULL,
  `asiento_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `UK_rkavvwbijd86sxebbemtdxiht` (`cliente_id` ASC),
  UNIQUE INDEX `UK_qqjegc9utry0gpixw9ql8yng2` (`pasaje_id` ASC),
  INDEX `FKsw4du2vel0094r1ed4wovdb8` (`asiento_id` ASC),
  CONSTRAINT `FK2f0q7f90k3mqx8x6rvy1emc40`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `aeropuerto_sv`.`clientes` (`dni`),
  CONSTRAINT `FK5o51wugjd7wivkuyahtnyqicg`
    FOREIGN KEY (`pasaje_id`)
    REFERENCES `aeropuerto_sv`.`pasajes` (`id_pasaje`),
  CONSTRAINT `FKsw4du2vel0094r1ed4wovdb8`
    FOREIGN KEY (`asiento_id`)
    REFERENCES `aeropuerto_sv`.`asientos_aviones` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- Insertar datos en la tabla `aviones`
INSERT INTO `aeropuerto_sv`.`aviones` (`fila`, `columna`, `nombre`) VALUES
(10, 6, 'Avion1'),
(8, 4, 'Avion2'),
(12, 8, 'Avion3');

-- Insertar datos en la tabla `asientos`
INSERT INTO `aeropuerto_sv`.`asientos_aviones` (`id`, `disponible`, `avion_id`) VALUES
('1-A1', true, 1),('1-A2', true, 1),('1-A3', true, 1),('1-A4', true, 1),('1-A5', true, 1),('1-A6', true, 1),('1-A7', true, 1),('1-A8', true, 1),('1-A9', true, 1),('1-A10', true, 1),
('1-B1', true, 1),('1-B2', true, 1),('1-B3', true, 1),('1-B4', true, 1),('1-B5', true, 1),('1-B6', true, 1),('1-B7', true, 1),('1-B8', true, 1),('1-B9', true, 1),('1-B10', true, 1),
('1-C1', true, 1),('1-C2', true, 1),('1-C3', true, 1),('1-C4', true, 1),('1-C5', true, 1),('1-C6', true, 1),('1-C7', true, 1),('1-C8', true, 1),('1-C9', true, 1),('1-C10', true, 1),
('1-D1', true, 1),('1-D2', true, 1),('1-D3', true, 1),('1-D4', true, 1),('1-D5', true, 1),('1-D6', true, 1),('1-D7', true, 1),('1-D8', true, 1),('1-D9', true, 1),('1-D10', true, 1),
('1-E1', true, 1),('1-E2', true, 1),('1-E3', true, 1),('1-E4', true, 1),('1-E5', true, 1),('1-E6', true, 1),('1-E7', true, 1),('1-E8', true, 1),('1-E9', true, 1),('1-E10', true, 1),
('1-F1', true, 1),('1-F2', true, 1),('1-F3', true, 1),('1-F4', true, 1),('1-F5', true, 1),('1-F6', true, 1),('1-F7', true, 1),('1-F8', true, 1),('1-F9', true, 1),('1-F10', true, 1),
('2-A1', true, 2),('2-A2', true, 2),('2-A3', true, 2),('2-A4', true, 2),('2-A5', true, 2),('2-A6', true, 2),('2-A7', true, 2),('2-A8', true, 2),
('2-B1', true, 2),('2-B2', true, 2),('2-B3', true, 2),('2-B4', true, 2),('2-B5', true, 2),('2-B6', true, 2),('2-B7', true, 2),('2-B8', true, 2),
('2-C1', true, 2),('2-C2', true, 2),('2-C3', true, 2),('2-C4', true, 2),('2-C5', true, 2),('2-C6', true, 2),('2-C7', true, 2),('2-C8', true, 2),
('2-D1', true, 2),('2-D2', true, 2),('2-D3', true, 2),('2-D4', true, 2),('2-D5', true, 2),('2-D6', true, 2),('2-D7', true, 2),('2-D8', true, 2),
('3-A1', true, 3),('3-A2', true, 3),('3-A3', true, 3),('3-A4', true, 3),('3-A5', true, 3),('3-A6', true, 3),('3-A7', true, 3),('3-A8', true, 3),('3-A9', true, 3),('3-A10', true, 3),('3-A11', true, 3),('3-A12', true, 3),
('3-B1', true, 3),('3-B2', true, 3),('3-B3', true, 3),('3-B4', true, 3),('3-B5', true, 3),('3-B6', true, 3),('3-B7', true, 3),('3-B8', true, 3),('3-B9', true, 3),('3-B10', true, 3),('3-B11', true, 3),('3-B12', true, 3),
('3-C1', true, 3),('3-C2', true, 3),('3-C3', true, 3),('3-C4', true, 3),('3-C5', true, 3),('3-C6', true, 3),('3-C7', true, 3),('3-C8', true, 3),('3-C9', true, 3),('3-C10', true, 3),('3-C11', true, 3),('3-C12', true, 3),
('3-D1', true, 3),('3-D2', true, 3),('3-D3', true, 3),('3-D4', true, 3),('3-D5', true, 3),('3-D6', true, 3),('3-D7', true, 3),('3-D8', true, 3),('3-D9', true, 3),('3-D10', true, 3),('3-D11', true, 3),('3-D12', true, 3),
('3-E1', true, 3),('3-E2', true, 3),('3-E3', true, 3),('3-E4', true, 3),('3-E5', true, 3),('3-E6', true, 3),('3-E7', true, 3),('3-E8', true, 3),('3-E9', true, 3),('3-E10', true, 3),('3-E11', true, 3),('3-E12', true, 3),
('3-F1', true, 3),('3-F2', true, 3),('3-F3', true, 3),('3-F4', true, 3),('3-F5', true, 3),('3-F6', true, 3),('3-F7', true, 3),('3-F8', true, 3),('3-F9', true, 3),('3-F10', true, 3),('3-F11', true, 3),('3-F12', true, 3),
('3-G1', true, 3),('3-G2', true, 3),('3-G3', true, 3),('3-G4', true, 3),('3-G5', true, 3),('3-G6', true, 3),('3-G7', true, 3),('3-G8', true, 3),('3-G9', true, 3),('3-G10', true, 3),('3-G11', true, 3),('3-G12', true, 3),
('3-H1', true, 3),('3-H2', true, 3),('3-H3', true, 3),('3-H4', true, 3),('3-H5', true, 3),('3-H6', true, 3),('3-H7', true, 3),('3-H8', true, 3),('3-H9', true, 3),('3-H10', true, 3),('3-H11', true, 3),('3-H12', true, 3);

-- Insertar datos en la tabla `clientes`
INSERT INTO `aeropuerto_sv`.`clientes` (`apellido`, `nombre`, `domicilio`, `nacimiento`, `mail`) VALUES
    ('González', 'Juan', 'Calle 123', '1990-05-15', 'juan@gmail.com'),
    ('López', 'María', 'Av. Principal', '1985-08-20', 'maria@hotmail.com'),
    ('Martínez', 'Carlos', 'Calle 456', '1992-01-10', 'carlos@yahoo.com'),
    ('Rodríguez', 'Ana', 'Av. Secundaria', '1988-11-05', 'ana@gmail.com'),
    ('Pérez', 'Luis', 'Calle 789', '1995-03-25', 'luis@hotmail.com');

    -- Insertar datos en la tabla `ciudades`
INSERT INTO `aeropuerto_sv`.`ciudades` (`nombre`, `pais_ciudad`) VALUES
    ('Sauce Viejo', 1),
    ('Rosario', 1),
    ('Buenos Aires', 1),
    ('Cordoba', 1),
    ('Lima', 2),
    ('New York', 3),
    ('Miami', 3),
    ('Rio de Janeiro', 4),
    ('Brasilia', 4);
    
    
    -- Insertar datos en la tabla `paises`
INSERT INTO `aeropuerto_sv`.`pais` (`nombre`) VALUES
    ('Argentina'),
    ('Peru'),
    ('Estados Unidos'),
    ('Brasil');

    -- Insertar datos en la tabla `pasaportes`
INSERT INTO `aeropuerto_sv`.`pasaportes` (`expiracion`, `n_pasaporte`, `cliente_id`) VALUES
    ('2025-01-10', 'ad125112544d', 4),
    ('2024-01-10', 'jjnh23522614', 5);
    
    

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
