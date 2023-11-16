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
  `id` BIGINT NOT NULL,
  `columna` INT NULL DEFAULT NULL,
  `fila` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`asientos_aviones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`asientos_aviones` (
  `numero_asiento` VARCHAR(255) NOT NULL,
  `disponible` BIT(1) NULL DEFAULT NULL,
  `avion_id` BIGINT NOT NULL,
  PRIMARY KEY (`avion_id`, `numero_asiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`clientes` (
  `dni` BIGINT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `domicilio` VARCHAR(255) NULL DEFAULT NULL,
  `nacimiento` DATE NULL DEFAULT NULL,
  `mail` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`vuelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`vuelos` (
  `id_vuelo` BIGINT NOT NULL AUTO_INCREMENT,
  `origen` VARCHAR(255) NULL DEFAULT NULL,
  `destino` VARCHAR(255) NULL DEFAULT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `hora` TIME NULL DEFAULT NULL,
  `nro_vuelo` VARCHAR(255) NULL DEFAULT NULL, 
  PRIMARY KEY (`id_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`internacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`internacionales` (
  `precio` DOUBLE NULL DEFAULT NULL,
  `tasa` DOUBLE NULL DEFAULT NULL,
  `id_vuelo` BIGINT NOT NULL,
  PRIMARY KEY (`id_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`nacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`nacionales` (
  `precio` DOUBLE NULL DEFAULT NULL,
  `tasa` DOUBLE NULL DEFAULT NULL,
  `id_vuelo` BIGINT NOT NULL,
  PRIMARY KEY (`id_vuelo`))
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
  `vuelo_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_pasaje`))
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
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
