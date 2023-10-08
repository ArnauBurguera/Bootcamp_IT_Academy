-- MySQL Workbench Synchronization
-- Generated: 2023-06-20 15:19
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Arnau

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Optica_Cul_d'ampolla` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`proveïdors` (
  `proveïdor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `telèfon` INT(10) UNSIGNED NOT NULL,
  `Fax` INT(10) UNSIGNED NOT NULL,
  `NIF` VARCHAR(9) NOT NULL,
  `Carrer` VARCHAR(50) NOT NULL,
  `Número` INT(11) NOT NULL,
  `pis` INT(11) NULL DEFAULT NULL,
  `Porta` INT(11) NULL DEFAULT NULL,
  `Ciutat` VARCHAR(60) NOT NULL,
  `Codi postal` INT(10) UNSIGNED NOT NULL,
  `País` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`proveïdor_id`),
  UNIQUE INDEX `proveïdor_id_UNIQUE` (`proveïdor_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`Marca` (
  `Marca_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nom_Marca` VARCHAR(45) NOT NULL,
  `proveïdors_proveïdor_id` INT(11) NOT NULL,
  PRIMARY KEY (`Marca_id`),
  INDEX `fk_Marca_proveïdors_idx` (`proveïdors_proveïdor_id` ASC) VISIBLE,
  UNIQUE INDEX `Marca_id_UNIQUE` (`Marca_id` ASC) VISIBLE,
  CONSTRAINT `fk_Marca_proveïdors`
    FOREIGN KEY (`proveïdors_proveïdor_id`)
    REFERENCES `Optica_Cul_d'ampolla`.`proveïdors` (`proveïdor_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`Ulleres` (
  `Ulleres_id` INT(11) NOT NULL,
  `Marca_id` INT(11) NOT NULL,
  `Graduació_vidres` INT(11) NOT NULL,
  `Tipus_montura` VARCHAR(10) NOT NULL,
  `Color_montura` VARCHAR(20) NOT NULL,
  `Color_vidre_dret` VARCHAR(20) NOT NULL,
  `Color_vidre_esquerre` VARCHAR(20) NOT NULL,
  `Preu` DECIMAL UNSIGNED NOT NULL,
  PRIMARY KEY (`Ulleres_id`),
  INDEX `fk_Ulleres_Marca1_idx` (`Marca_id` ASC) VISIBLE,
  UNIQUE INDEX `Ulleres_id_UNIQUE` (`Ulleres_id` ASC) VISIBLE,
  CONSTRAINT `fk_Ulleres_Marca1`
    FOREIGN KEY (`Marca_id`)
    REFERENCES `Optica_Cul_d'ampolla`.`Marca` (`Marca_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`Venta` (
  `Venta_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Ulleres_id` INT(11) NOT NULL,
  `Venedor_id` INT(11) NOT NULL,
  `Clients_Client_id` INT(11) NOT NULL,
  INDEX `fk_Venta_Ulleres1_idx` (`Ulleres_id` ASC) VISIBLE,
  PRIMARY KEY (`Venta_id`),
  INDEX `fk_Venta_Venedor1_idx` (`Venedor_id` ASC) VISIBLE,
  UNIQUE INDEX `Venta_id_UNIQUE` (`Venta_id` ASC) VISIBLE,
  INDEX `fk_Venta_Clients1_idx` (`Clients_Client_id` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Ulleres1`
    FOREIGN KEY (`Ulleres_id`)
    REFERENCES `Optica_Cul_d'ampolla`.`Ulleres` (`Ulleres_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Venta_Venedor1`
    FOREIGN KEY (`Venedor_id`)
    REFERENCES `Optica_Cul_d'ampolla`.`Venedor` (`Venedor_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Venta_Clients1`
    FOREIGN KEY (`Clients_Client_id`)
    REFERENCES `Optica_Cul_d'ampolla`.`Clients` (`Client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`Venedor` (
  `Venedor_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Venedor_id`),
  UNIQUE INDEX `Venedor_id_UNIQUE` (`Venedor_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica_Cul_d'ampolla`.`Clients` (
  `Client_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nom_client` VARCHAR(45) NOT NULL,
  `Adreça_postal` VARCHAR(80) NOT NULL,
  `Telefon` INT(11) NOT NULL,
  `Correu_electrònic` VARCHAR(50) NOT NULL,
  `Data_registre` DATETIME NOT NULL,
  `Font_recomanació` VARCHAR(45) NULL DEFAULT NULL,
  UNIQUE INDEX `Client_id_UNIQUE` (`Client_id` ASC) VISIBLE,
  PRIMARY KEY (`Client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
