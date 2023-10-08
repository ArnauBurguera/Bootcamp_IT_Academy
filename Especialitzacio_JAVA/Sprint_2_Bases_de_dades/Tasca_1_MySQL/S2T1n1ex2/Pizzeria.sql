-- MySQL Workbench Synchronization
-- Generated: 2023-06-21 09:45
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Arnau

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Pizzeria` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Clients` (
  `Client_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Cognoms` VARCHAR(65) NOT NULL,
  `Adreça` VARCHAR(45) NOT NULL,
  `Codi postal` INT(10) UNSIGNED NOT NULL,
  `Telèfon` INT(10) UNSIGNED NOT NULL,
  `Localitat_id` INT(10) UNSIGNED NOT NULL,
  `Província_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Client_id`),
  UNIQUE INDEX `Client_id_UNIQUE` (`Client_id` ASC) VISIBLE,
  INDEX `fk_Clients_Localitats1_idx` (`Localitat_id` ASC) VISIBLE,
  INDEX `fk_Clients_Províncies1_idx` (`Província_id` ASC) VISIBLE,
  CONSTRAINT `fk_Clients_Localitats1`
    FOREIGN KEY (`Localitat_id`)
    REFERENCES `Pizzeria`.`Localitats` (`Localitat_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Clients_Províncies1`
    FOREIGN KEY (`Província_id`)
    REFERENCES `Pizzeria`.`Províncies` (`Província_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Províncies` (
  `Província_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Província_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Localitats` (
  `Localitat_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Província_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Localitat_id`),
  INDEX `fk_Localitats_Províncies_idx` (`Província_id` ASC) VISIBLE,
  CONSTRAINT `fk_Localitats_Províncies`
    FOREIGN KEY (`Província_id`)
    REFERENCES `Pizzeria`.`Províncies` (`Província_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Comandes` (
  `Comanda_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data/Hora` DATETIME NOT NULL,
  `Domicili(D)/Boriga(B)` VARCHAR(1) BINARY NOT NULL,
  `Quantitat Begudes` INT(10) UNSIGNED NOT NULL,
  `Quantitat Hamburgueses` INT(10) UNSIGNED NOT NULL,
  `Quantitat Pizzes` INT(10) UNSIGNED NOT NULL,
  `Preu total` DECIMAL UNSIGNED NOT NULL,
  `Client_id` INT(11) NOT NULL,
  `Producte_id` INT(10) UNSIGNED NOT NULL,
  `Localitat_id` INT(10) UNSIGNED NOT NULL,
  `Província_id` INT(10) UNSIGNED NOT NULL,
  `Repartidor_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  `Lluirament` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`Comanda_id`),
  INDEX `fk_Comandes_Clients1_idx` (`Client_id` ASC) VISIBLE,
  INDEX `fk_Comandes_Productes1_idx` (`Producte_id` ASC) VISIBLE,
  INDEX `fk_Comandes_Localitats1_idx` (`Localitat_id` ASC) VISIBLE,
  INDEX `fk_Comandes_Províncies1_idx` (`Província_id` ASC) VISIBLE,
  INDEX `fk_Comandes_Empleats1_idx` (`Repartidor_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comandes_Clients1`
    FOREIGN KEY (`Client_id`)
    REFERENCES `Pizzeria`.`Clients` (`Client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comandes_Productes1`
    FOREIGN KEY (`Producte_id`)
    REFERENCES `Pizzeria`.`Productes` (`Producte_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comandes_Localitats1`
    FOREIGN KEY (`Localitat_id`)
    REFERENCES `Pizzeria`.`Localitats` (`Localitat_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comandes_Províncies1`
    FOREIGN KEY (`Província_id`)
    REFERENCES `Pizzeria`.`Províncies` (`Província_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comandes_Empleats1`
    FOREIGN KEY (`Repartidor_id`)
    REFERENCES `Pizzeria`.`Empleats` (`Empleat_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Productes` (
  `Producte_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Descripció` TINYTEXT NOT NULL,
  `Imatge` VARCHAR(100) NOT NULL,
  `Preu` DECIMAL NOT NULL,
  `Categoria_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Producte_id`),
  INDEX `fk_Productes_Categoria Pizzes1_idx` (`Categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_Productes_Categoria Pizzes1`
    FOREIGN KEY (`Categoria_id`)
    REFERENCES `Pizzeria`.`Categoria Pizzes` (`Categoria_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Categoria Pizzes` (
  `Categoria_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Categoria_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Botigues` (
  `Botiga_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Adreça` VARCHAR(85) NOT NULL,
  `Codi Postal` INT(10) UNSIGNED NOT NULL,
  `Localitat_id` INT(10) UNSIGNED NOT NULL,
  `Província_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Botiga_id`),
  INDEX `fk_Botigues_Localitats1_idx` (`Localitat_id` ASC) VISIBLE,
  INDEX `fk_Botigues_Províncies1_idx` (`Província_id` ASC) VISIBLE,
  CONSTRAINT `fk_Botigues_Localitats1`
    FOREIGN KEY (`Localitat_id`)
    REFERENCES `Pizzeria`.`Localitats` (`Localitat_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Botigues_Províncies1`
    FOREIGN KEY (`Província_id`)
    REFERENCES `Pizzeria`.`Províncies` (`Província_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`Empleats` (
  `Empleat_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Cognoms` VARCHAR(65) NOT NULL,
  `NIF` VARCHAR(12) NOT NULL,
  `Telèfon` INT(10) UNSIGNED NOT NULL,
  `LLoc_de_treball(C/R)` VARCHAR(1) BINARY NOT NULL COMMENT 'C = Cuiner/a\nR = Repartidor/a',
  PRIMARY KEY (`Empleat_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
