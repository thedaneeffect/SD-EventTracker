-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema moodtracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moodtracker` ;

-- -----------------------------------------------------
-- Schema moodtracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moodtracker` DEFAULT CHARACTER SET utf8 ;
USE `moodtracker` ;

-- -----------------------------------------------------
-- Table `moodtracker`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moodtracker`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(512) NOT NULL,
  `role` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  `created_on` DATETIME NULL,
  `updated_on` DATETIME NULL,
  `uuid` VARCHAR(512) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moodtracker`.`mood`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moodtracker`.`mood` (
  `id` DATE NOT NULL,
  `user_id` INT NOT NULL,
  `value` INT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_mood_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_mood_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `moodtracker`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `moodtracker`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `moodtracker`;
INSERT INTO `moodtracker`.`user` (`id`, `name`, `password`, `role`, `enabled`, `created_on`, `updated_on`, `uuid`) VALUES (DEFAULT, 'dane', '$2a$10$g5ecCfZBSXhlI8zI/PC.LeeHmYRS4MhX70f063yiS9aWfbm/UGtg2', 'standard', 1, '2022-01-01 00:00:00', '2022-01-01 00:00:00', '04656eff-a9e9-429c-9a87-b594847af4da');

COMMIT;


-- -----------------------------------------------------
-- Data for table `moodtracker`.`mood`
-- -----------------------------------------------------
START TRANSACTION;
USE `moodtracker`;
INSERT INTO `moodtracker`.`mood` (`id`, `user_id`, `value`, `description`) VALUES ('2022-01-01', 1, 4, 'It\'s new years!');

COMMIT;

