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
  PRIMARY KEY (`avion_id`, `numero_asiento`),
  CONSTRAINT `FKqhjyd1s4si5kudxx9yu3jtr3`
    FOREIGN KEY (`avion_id`)
    REFERENCES `aeropuerto_sv`.`aviones` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`ciudades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`clientes` (
  `dni` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
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
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `hora` TIME NULL DEFAULT NULL,
  `nro_vuelo` VARCHAR(255) NULL DEFAULT NULL,
  `ciudad_destino` INT NULL DEFAULT NULL,
  `ciudad_origen` INT NULL DEFAULT NULL,
  `avion_asignado` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_vuelo`),
  INDEX `FK4sv51m9yjrxs4nqqropq158xa` (`ciudad_destino` ASC),
  INDEX `FK1ax28yasqhf9v3e0lnolxasl5` (`ciudad_origen` ASC),
  INDEX `FKirk1kyhpnneccfm851408q0tp` (`avion_asignado` ASC),
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
-- Table `aeropuerto_sv`.`internacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`internacionales` (
  `precio` DOUBLE NULL DEFAULT NULL,
  `tasa` DOUBLE NULL DEFAULT NULL,
  `id_vuelo` BIGINT NOT NULL,
  PRIMARY KEY (`id_vuelo`),
  CONSTRAINT `FKfx0sd59m3gxok9c0xyokuyv38`
    FOREIGN KEY (`id_vuelo`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`id_vuelo`))
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
  PRIMARY KEY (`id_vuelo`),
  CONSTRAINT `FKa4r4i1w1wg2covpt3bjs8xnom`
    FOREIGN KEY (`id_vuelo`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`id_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `aeropuerto_sv`.`pasajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aeropuerto_sv`.`pasajes` (
  `id_pasaje` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  `vuelo_id` BIGINT NULL DEFAULT NULL,
  `precio_total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_pasaje`),
  INDEX `FK7p44jddxs6fpkc3b1uo38528` (`cliente_id` ASC),
  INDEX `FK83k3kj099oxb7r8bovhfpu9og` (`vuelo_id` ASC),
  CONSTRAINT `FK7p44jddxs6fpkc3b1uo38528`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `aeropuerto_sv`.`clientes` (`dni`),
  CONSTRAINT `FK83k3kj099oxb7r8bovhfpu9og`
    FOREIGN KEY (`vuelo_id`)
    REFERENCES `aeropuerto_sv`.`vuelos` (`id_vuelo`))
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
