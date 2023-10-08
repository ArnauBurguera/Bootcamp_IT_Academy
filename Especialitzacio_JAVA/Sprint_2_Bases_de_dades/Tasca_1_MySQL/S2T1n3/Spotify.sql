-- MySQL Workbench Synchronization
-- Generated: 2023-06-26 11:20
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Arnau

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Spotify` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Spotify`.`Usuari` (
  `Usuari_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Nom` VARCHAR(45) NOT NULL,
  `Data_naixemenet` DATE NOT NULL,
  `Sexe` VARCHAR(1) BINARY NOT NULL,
  `País` VARCHAR(45) NOT NULL,
  `Codi_postal` INT(10) UNSIGNED NOT NULL,
  `Subscripcions_Subscripció_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Usuari_id`),
  INDEX `fk_Usuari_Subscripcions_idx` (`Subscripcions_Subscripció_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuari_Subscripcions`
    FOREIGN KEY (`Subscripcions_Subscripció_id`)
    REFERENCES `Spotify`.`Subscripcions` (`Subscripció_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Subscripcions` (
  `Subscripció_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data_inici_sub` DATETIME NOT NULL,
  `Data_renovació` DATE NOT NULL,
  `Mètode_pagament` VARCHAR(1) BINARY NOT NULL COMMENT 'C = Credit\nP = Paypal',
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Subscripció_id`),
  INDEX `fk_Subscripcions_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Subscripcions_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Crèdit` (
  `Targeta_Crèdit` INT(10) UNSIGNED NOT NULL,
  `Data_caducitat` DATE NOT NULL,
  `Codi_seguretat` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Targeta_Crèdit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Paypal` (
  `Paypal_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom_usuari_paypal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Paypal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Pagament` (
  `Pagament_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data_pagament` VARCHAR(45) NOT NULL,
  `Numero_ordre` INT(10) UNSIGNED NOT NULL,
  `Total` INT(11) NOT NULL,
  `Subscripcions_Subscripció_id` INT(10) UNSIGNED NOT NULL,
  `Paypal_Paypal_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  `Crèdit_Targeta_Crèdit` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`Pagament_id`),
  UNIQUE INDEX `Numero_ordre_UNIQUE` (`Numero_ordre` ASC) VISIBLE,
  INDEX `fk_Pagament_Subscripcions1_idx` (`Subscripcions_Subscripció_id` ASC) VISIBLE,
  INDEX `fk_Pagament_Paypal1_idx` (`Paypal_Paypal_id` ASC) VISIBLE,
  INDEX `fk_Pagament_Crèdit1_idx` (`Crèdit_Targeta_Crèdit` ASC) VISIBLE,
  CONSTRAINT `fk_Pagament_Subscripcions1`
    FOREIGN KEY (`Subscripcions_Subscripció_id`)
    REFERENCES `Spotify`.`Subscripcions` (`Subscripció_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pagament_Paypal1`
    FOREIGN KEY (`Paypal_Paypal_id`)
    REFERENCES `Spotify`.`Paypal` (`Paypal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pagament_Crèdit1`
    FOREIGN KEY (`Crèdit_Targeta_Crèdit`)
    REFERENCES `Spotify`.`Crèdit` (`Targeta_Crèdit`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Playlists` (
  `Playlist_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Títol_playlist` VARCHAR(45) NOT NULL,
  `Nombre_cançons` INT(10) UNSIGNED NOT NULL,
  `Data_creació` DATE NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Playlist_Eliminada` VARCHAR(1) BINARY NOT NULL COMMENT 'S = Si\nN = No',
  `Data_eliminació` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Playlist_id`),
  INDEX `fk_Playlists_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Playlists_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Cançó_afegida` (
  `Cançó_afegida_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data_addició` DATE NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Cançó_Cançó_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Cançó_afegida_id`),
  INDEX `fk_Cançó_compartida_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Cançó_afegida_Cançó1_idx` (`Cançó_Cançó_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cançó_compartida_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Cançó_afegida_Cançó1`
    FOREIGN KEY (`Cançó_Cançó_id`)
    REFERENCES `Spotify`.`Cançó` (`Cançó_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Àlbum` (
  `Àlbum_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Artista_Artista_id` INT(10) UNSIGNED NOT NULL,
  `Títol` VARCHAR(45) NOT NULL,
  `Any_publiació` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Àlbum_id`),
  INDEX `fk_Àlbum_Artista1_idx` (`Artista_Artista_id` ASC) VISIBLE,
  CONSTRAINT `fk_Àlbum_Artista1`
    FOREIGN KEY (`Artista_Artista_id`)
    REFERENCES `Spotify`.`Artista` (`Artista_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Cançó` (
  `Cançó_id` INT(10) UNSIGNED NOT NULL,
  `Títol` VARCHAR(45) NOT NULL,
  `Durada` INT(11) NOT NULL COMMENT 'En segons',
  `Reproduccions` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Àlbum_Àlbum_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Cançó_id`),
  INDEX `fk_Cançó_Àlbum1_idx` (`Àlbum_Àlbum_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cançó_Àlbum1`
    FOREIGN KEY (`Àlbum_Àlbum_id`)
    REFERENCES `Spotify`.`Àlbum` (`Àlbum_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Artista` (
  `Artista_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Imatge_artista` VARCHAR(105) NOT NULL,
  `Gènere_Gènere_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Artista_id`),
  INDEX `fk_Artista_Gènere1_idx` (`Gènere_Gènere_id` ASC) VISIBLE,
  CONSTRAINT `fk_Artista_Gènere1`
    FOREIGN KEY (`Gènere_Gènere_id`)
    REFERENCES `Spotify`.`Gènere` (`Gènere_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Seguiment_Artistes` (
  `Seguiment_Artistes_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Artista_Artista_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Seguiment_Artistes_id`),
  INDEX `fk_Seguiment_Artistes_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Seguiment_Artistes_Artista1_idx` (`Artista_Artista_id` ASC) VISIBLE,
  CONSTRAINT `fk_Seguiment_Artistes_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Seguiment_Artistes_Artista1`
    FOREIGN KEY (`Artista_Artista_id`)
    REFERENCES `Spotify`.`Artista` (`Artista_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Gènere` (
  `Gènere_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom_gènere` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Gènere_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Àlbums_preferits` (
  `Àlbum_preferi_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Àlbum_Àlbum_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Àlbum_preferi_id`),
  INDEX `fk_Àlbums_preferits_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Àlbums_preferits_Àlbum1_idx` (`Àlbum_Àlbum_id` ASC) VISIBLE,
  CONSTRAINT `fk_Àlbums_preferits_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Àlbums_preferits_Àlbum1`
    FOREIGN KEY (`Àlbum_Àlbum_id`)
    REFERENCES `Spotify`.`Àlbum` (`Àlbum_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Spotify`.`Cançons_preferides` (
  `Cançó_preferida_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Cançó_Cançó_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Cançó_preferida_id`),
  INDEX `fk_Cançons_preferides_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Cançons_preferides_Cançó1_idx` (`Cançó_Cançó_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cançons_preferides_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Spotify`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Cançons_preferides_Cançó1`
    FOREIGN KEY (`Cançó_Cançó_id`)
    REFERENCES `Spotify`.`Cançó` (`Cançó_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
