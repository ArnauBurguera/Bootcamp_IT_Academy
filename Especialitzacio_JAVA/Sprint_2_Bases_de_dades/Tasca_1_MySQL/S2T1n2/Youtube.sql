-- MySQL Workbench Synchronization
-- Generated: 2023-06-26 09:40
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Arnau

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Youtube` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Youtube`.`Usuari` (
  `Usuari_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(65) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Nom` VARCHAR(45) NOT NULL,
  `Data_naixement` DATE NOT NULL,
  `Sexe` VARCHAR(1) NOT NULL COMMENT 'H = Home\nD = Dona',
  `País` VARCHAR(75) NOT NULL,
  `Codi_Postal` INT(10) UNSIGNED NOT NULL,
  `Canals_Canal_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Usuari_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `Password_UNIQUE` (`Password` ASC) VISIBLE,
  INDEX `fk_Usuari_Canals1_idx` (`Canals_Canal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuari_Canals1`
    FOREIGN KEY (`Canals_Canal_id`)
    REFERENCES `Youtube`.`Canals` (`Canal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Videos` (
  `Video_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Títol` VARCHAR(75) NOT NULL,
  `Descripció` TEXT(300) NOT NULL,
  `Grandària` INT(10) UNSIGNED NOT NULL COMMENT 'En MB',
  `nom_arxiu_video` VARCHAR(75) NOT NULL,
  `Durada` INT(10) UNSIGNED NOT NULL COMMENT 'En segons.',
  `Thumbnail` VARCHAR(100) NOT NULL,
  `Reproduccions` INT(10) UNSIGNED NOT NULL,
  `Nombre_Likes` INT(10) UNSIGNED NOT NULL,
  `Nombre_Dislikes` INT(10) UNSIGNED NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Estat` VARCHAR(6) NOT NULL COMMENT 'Public\nOcult\nPrivat',
  `Data_publicaió` DATETIME NOT NULL,
  `Playlists_Playlist_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`Video_id`),
  INDEX `fk_Videos_Usuari_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Videos_Playlists1_idx` (`Playlists_Playlist_id` ASC) VISIBLE,
  CONSTRAINT `fk_Videos_Usuari`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Videos_Playlists1`
    FOREIGN KEY (`Playlists_Playlist_id`)
    REFERENCES `Youtube`.`Playlists` (`Playlist_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Etiquetes` (
  `Etiqueta_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom_Etiqueta` VARCHAR(45) NOT NULL,
  `Videos_Video_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Etiqueta_id`),
  INDEX `fk_Etiquetes_Videos1_idx` (`Videos_Video_id` ASC) VISIBLE,
  CONSTRAINT `fk_Etiquetes_Videos1`
    FOREIGN KEY (`Videos_Video_id`)
    REFERENCES `Youtube`.`Videos` (`Video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Canals` (
  `Canal_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Descripció` TINYTEXT NOT NULL,
  `Data_creació_canal` DATETIME NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Canal_id`),
  INDEX `fk_Canals_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Canals_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Subscripcions` (
  `Subscripció_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Canals_Canal_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Subscripció_id`),
  INDEX `fk_Subscripcions_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Subscripcions_Canals1_idx` (`Canals_Canal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Subscripcions_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Subscripcions_Canals1`
    FOREIGN KEY (`Canals_Canal_id`)
    REFERENCES `Youtube`.`Canals` (`Canal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Likes` (
  `Like_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Videos_Video_id` INT(10) UNSIGNED NOT NULL,
  `Data_like` DATETIME NOT NULL,
  INDEX `fk_Likes_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  INDEX `fk_Likes_Videos1_idx` (`Videos_Video_id` ASC) VISIBLE,
  PRIMARY KEY (`Like_id`),
  CONSTRAINT `fk_Likes_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Likes_Videos1`
    FOREIGN KEY (`Videos_Video_id`)
    REFERENCES `Youtube`.`Videos` (`Video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Dislikes` (
  `Dislike_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Videos_Video_id` INT(10) UNSIGNED NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  `Data_dislike` DATETIME NOT NULL,
  PRIMARY KEY (`Dislike_id`),
  INDEX `fk_Dislikes_Videos1_idx` (`Videos_Video_id` ASC) VISIBLE,
  INDEX `fk_Dislikes_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Dislikes_Videos1`
    FOREIGN KEY (`Videos_Video_id`)
    REFERENCES `Youtube`.`Videos` (`Video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Dislikes_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Playlists` (
  `Playlist_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Data_creació_playlist` DATETIME NOT NULL,
  `Estat` VARCHAR(10) BINARY NOT NULL COMMENT 'Pública o Privada',
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Playlist_id`),
  INDEX `fk_PLaylists_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_PLaylists_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Comentaris` (
  `Comentari_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Text_comentari` TEXT(500) NOT NULL,
  `Data_comentari` DATETIME NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Comentari_id`),
  INDEX `fk_Comentaris_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comentaris_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Comentari_Likes` (
  `Comentari_likei_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data_like_comentari` DATETIME NOT NULL,
  `Comentaris_Comentari_id` INT(10) UNSIGNED NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Comentari_likei_id`),
  INDEX `fk_Comentari_Likes_Comentaris1_idx` (`Comentaris_Comentari_id` ASC) VISIBLE,
  INDEX `fk_Comentari_Likes_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comentari_Likes_Comentaris1`
    FOREIGN KEY (`Comentaris_Comentari_id`)
    REFERENCES `Youtube`.`Comentaris` (`Comentari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comentari_Likes_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Youtube`.`Comentari_Dislikes` (
  `Comentari_Dislike_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Data_Dislike_comentari` DATETIME NOT NULL,
  `Comentaris_Comentari_id` INT(10) UNSIGNED NOT NULL,
  `Usuari_Usuari_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Comentari_Dislike_id`),
  INDEX `fk_Comentari_Dislikes_Comentaris1_idx` (`Comentaris_Comentari_id` ASC) VISIBLE,
  INDEX `fk_Comentari_Dislikes_Usuari1_idx` (`Usuari_Usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comentari_Dislikes_Comentaris1`
    FOREIGN KEY (`Comentaris_Comentari_id`)
    REFERENCES `Youtube`.`Comentaris` (`Comentari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Comentari_Dislikes_Usuari1`
    FOREIGN KEY (`Usuari_Usuari_id`)
    REFERENCES `Youtube`.`Usuari` (`Usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
