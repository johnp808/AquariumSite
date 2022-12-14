-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema aquariumdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aquariumdb` ;

-- -----------------------------------------------------
-- Schema aquariumdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aquariumdb` DEFAULT CHARACTER SET utf8 ;
USE `aquariumdb` ;

-- -----------------------------------------------------
-- Table `aquarium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aquarium` ;

CREATE TABLE IF NOT EXISTS `aquarium` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aquarium_number` INT NULL,
  `tank_size_in_gallons` INT NOT NULL,
  `aquarium_type` VARCHAR(100) NULL,
  `amount_of_fish` INT NULL,
  `amount_of_plants` INT NULL,
  `aquarium_start_date` DATE NOT NULL,
  `picture_of_aquarium` VARCHAR(4500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fish` ;

CREATE TABLE IF NOT EXISTS `fish` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fish_name` VARCHAR(100) NOT NULL,
  `max_fish_size_inches` DECIMAL(4,2) NULL,
  `fish_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NULL,
  `age` INT NULL,
  `location` VARCHAR(100) NULL,
  `profile_picture` VARCHAR(4000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fish_has_aquarium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fish_has_aquarium` ;

CREATE TABLE IF NOT EXISTS `fish_has_aquarium` (
  `fish_id` INT NOT NULL,
  `aquarium_id` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`fish_id`, `aquarium_id`),
  INDEX `fk_fish_has_aquarium_aquarium1_idx` (`aquarium_id` ASC),
  INDEX `fk_fish_has_aquarium_fish1_idx` (`fish_id` ASC),
  CONSTRAINT `fk_fish_has_aquarium_fish1`
    FOREIGN KEY (`fish_id`)
    REFERENCES `fish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fish_has_aquarium_aquarium1`
    FOREIGN KEY (`aquarium_id`)
    REFERENCES `aquarium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_aquarium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_aquarium` ;

CREATE TABLE IF NOT EXISTS `user_has_aquarium` (
  `user_id` INT NOT NULL,
  `aquarium_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `aquarium_id`),
  INDEX `fk_user_has_aquarium_aquarium1_idx` (`aquarium_id` ASC),
  INDEX `fk_user_has_aquarium_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_aquarium_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_aquarium_aquarium1`
    FOREIGN KEY (`aquarium_id`)
    REFERENCES `aquarium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY '808';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `aquarium`
-- -----------------------------------------------------
START TRANSACTION;
USE `aquariumdb`;
INSERT INTO `aquarium` (`id`, `aquarium_number`, `tank_size_in_gallons`, `aquarium_type`, `amount_of_fish`, `amount_of_plants`, `aquarium_start_date`, `picture_of_aquarium`) VALUES (1, 1, 15, 'Freshwater', 10, 2, '2022-08-18', 'https://spec-tanks.com/wp-content/uploads/2014/12/14-002-0905.jpg');
INSERT INTO `aquarium` (`id`, `aquarium_number`, `tank_size_in_gallons`, `aquarium_type`, `amount_of_fish`, `amount_of_plants`, `aquarium_start_date`, `picture_of_aquarium`) VALUES (2, 2, 10, 'Freshwater', 20, 7, '2022-08-18', 'https://i.pinimg.com/736x/2e/e6/7c/2ee67cd1fe654ffded6f926517546015.jpg');
INSERT INTO `aquarium` (`id`, `aquarium_number`, `tank_size_in_gallons`, `aquarium_type`, `amount_of_fish`, `amount_of_plants`, `aquarium_start_date`, `picture_of_aquarium`) VALUES (3, 3, 3, 'Freshwater', 1, 4, '2022-08-18', 'https://fishlab.com/wp-content/uploads/2021/11/Betta-Fish-Tank-Setup2-1024x1024.jpg');
INSERT INTO `aquarium` (`id`, `aquarium_number`, `tank_size_in_gallons`, `aquarium_type`, `amount_of_fish`, `amount_of_plants`, `aquarium_start_date`, `picture_of_aquarium`) VALUES (4, 4, 5, 'Saltwater', 30, 0, '2022-08-19', 'https://japanesefightingfish.org/wp-content/uploads/2022/06/how-long-do-guppies-live.png');
INSERT INTO `aquarium` (`id`, `aquarium_number`, `tank_size_in_gallons`, `aquarium_type`, `amount_of_fish`, `amount_of_plants`, `aquarium_start_date`, `picture_of_aquarium`) VALUES (5, 5, 30, 'Freshwater', 55, 12, '2020-01-26', 'https://aquamarket.co.za/wp-content/uploads/2021/12/Neon-Tetra-Complete-Care-Guide-Banner.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `fish`
-- -----------------------------------------------------
START TRANSACTION;
USE `aquariumdb`;
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (1, 'Neon Tetra', 2, 'Freshwater');
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (2, 'Shrimp', 1.25, 'Freshwater');
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (3, 'Loach', 3.5, 'Freshwater');
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (4, 'Pufferfish', 7.5, 'Saltwater');
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (5, 'Feeder Fish', 1, 'Freshwater');
INSERT INTO `fish` (`id`, `fish_name`, `max_fish_size_inches`, `fish_type`) VALUES (6, 'Betta Fish', 3.75, 'Freshwater');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `aquariumdb`;
INSERT INTO `user` (`id`, `username`, `age`, `location`, `profile_picture`) VALUES (1, 'Uzidontbrick', 30, 'Hawaii', 'https://i.ibb.co/2d7Sj6Z/johngates.png');
INSERT INTO `user` (`id`, `username`, `age`, `location`, `profile_picture`) VALUES (2, 'AimiNakas', 27, 'Tokyo', 'https://i.ibb.co/whc0n0t/IMG-1602.png');
INSERT INTO `user` (`id`, `username`, `age`, `location`, `profile_picture`) VALUES (3, 'Tory', 18, 'New Hampshire', 'https://i.ibb.co/2d7Sj6Z/johngates.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `fish_has_aquarium`
-- -----------------------------------------------------
START TRANSACTION;
USE `aquariumdb`;
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (1, 1, 10);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (2, 1, 8);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (3, 1, 2);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (2, 2, 20);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (6, 3, 1);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (5, 4, 35);
INSERT INTO `fish_has_aquarium` (`fish_id`, `aquarium_id`, `quantity`) VALUES (1, 5, 25);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_aquarium`
-- -----------------------------------------------------
START TRANSACTION;
USE `aquariumdb`;
INSERT INTO `user_has_aquarium` (`user_id`, `aquarium_id`) VALUES (1, 1);
INSERT INTO `user_has_aquarium` (`user_id`, `aquarium_id`) VALUES (1, 2);
INSERT INTO `user_has_aquarium` (`user_id`, `aquarium_id`) VALUES (1, 3);
INSERT INTO `user_has_aquarium` (`user_id`, `aquarium_id`) VALUES (1, 4);
INSERT INTO `user_has_aquarium` (`user_id`, `aquarium_id`) VALUES (2, 5);

COMMIT;

