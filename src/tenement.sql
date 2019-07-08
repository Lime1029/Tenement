-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tenement
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tenement` ;

-- -----------------------------------------------------
-- Schema tenement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tenement` DEFAULT CHARACTER SET utf8 ;
USE `tenement` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL COMMENT '真实姓名',
  `username` VARCHAR(45) NULL,
  `balance` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `telephone_UNIQUE` (`telephone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `city` ;

CREATE TABLE IF NOT EXISTS `city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
COMMENT = '一级地址';


-- -----------------------------------------------------
-- Table `district`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `district` ;

CREATE TABLE IF NOT EXISTS `district` (
  `district_id` INT NOT NULL AUTO_INCREMENT,
  `district_name` VARCHAR(20) NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`district_id`),
  INDEX `fk_district_province_municipality1_idx` (`city_id` ASC),
  CONSTRAINT `fk_district_province_municipality1`
    FOREIGN KEY (`city_id`)
    REFERENCES `city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '二级地址';


-- -----------------------------------------------------
-- Table `agent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agent` ;

CREATE TABLE IF NOT EXISTS `agent` (
  `agent_id` INT NOT NULL AUTO_INCREMENT,
  `telephone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`agent_id`),
  UNIQUE INDEX `telephone_UNIQUE` (`telephone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `plot`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plot` ;

CREATE TABLE IF NOT EXISTS `plot` (
  `plot_id` INT NOT NULL AUTO_INCREMENT,
  `plot_name` VARCHAR(30) NOT NULL,
  `district_id` INT NOT NULL,
  `agent_id` INT NOT NULL,
  PRIMARY KEY (`plot_id`),
  INDEX `fk_plot_district1_idx` (`district_id` ASC),
  INDEX `fk_plot_agent1_idx` (`agent_id` ASC),
  CONSTRAINT `fk_plot_district1`
    FOREIGN KEY (`district_id`)
    REFERENCES `district` (`district_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plot_agent1`
    FOREIGN KEY (`agent_id`)
    REFERENCES `agent` (`agent_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '小区';


-- -----------------------------------------------------
-- Table `house`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house` ;

CREATE TABLE IF NOT EXISTS `house` (
  `house_id` INT NOT NULL AUTO_INCREMENT,
  `landlord_id` INT NOT NULL,
  `plot_id` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `rent` DOUBLE NOT NULL COMMENT '租金，以月为单位',
  `state` INT NOT NULL COMMENT '0代表不再出租，1代表出租中',
  `house_type` VARCHAR(20) NOT NULL COMMENT '几室几厅几卫',
  `floor` VARCHAR(10) NOT NULL,
  `area` DOUBLE NOT NULL,
  `house_description` TEXT(100) NOT NULL COMMENT '房源描述',
  `release_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`house_id`),
  INDEX `fk_house_user1_idx` (`landlord_id` ASC),
  INDEX `fk_house_plot1_idx` (`plot_id` ASC),
  CONSTRAINT `fk_house_user1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_house_plot1`
    FOREIGN KEY (`plot_id`)
    REFERENCES `plot` (`plot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order` ;

CREATE TABLE IF NOT EXISTS `order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `order_stime` DATE NOT NULL,
  `order_rent` INT UNSIGNED NOT NULL,
  `order_status` TINYINT NOT NULL DEFAULT 0 COMMENT '0表示未支付，1表示已支付',
  `order_etime` DATE NOT NULL,
  `applyer_id` INT NOT NULL,
  `house_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_order_user1_idx` (`applyer_id` ASC),
  INDEX `fk_order_house1_idx` (`house_id` ASC),
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`applyer_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`house_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `administrator` ;

CREATE TABLE IF NOT EXISTS `administrator` (
  `administrator_id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NULL,
  PRIMARY KEY (`administrator_id`),
  UNIQUE INDEX `email_UNIQUE` (`telephone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `discussion_section`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `discussion_section` ;

CREATE TABLE IF NOT EXISTS `discussion_section` (
  `message_id` INT NOT NULL AUTO_INCREMENT,
  `release_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `message` TEXT(200) NOT NULL,
  `author_id` INT NULL,
  PRIMARY KEY (`message_id`),
  INDEX `fk_discussion_board_user1_idx` (`author_id` ASC),
  CONSTRAINT `fk_discussion_board_user1`
    FOREIGN KEY (`author_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `log` ;

CREATE TABLE IF NOT EXISTS `log` (
  `log_id` INT NOT NULL AUTO_INCREMENT,
  `log` TEXT(200) NOT NULL,
  `record_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author_id` INT NULL,
  PRIMARY KEY (`log_id`),
  INDEX `fk_log_user1_idx` (`author_id` ASC),
  CONSTRAINT `fk_log_user1`
    FOREIGN KEY (`author_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback` ;

CREATE TABLE IF NOT EXISTS `feedback` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT,
  `feedback` TEXT(200) NOT NULL,
  `feedback_iime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author_id` INT NULL,
  PRIMARY KEY (`feedback_id`),
  INDEX `fk_feedback_user1_idx` (`author_id` ASC),
  CONSTRAINT `fk_feedback_user1`
    FOREIGN KEY (`author_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `landlord_apply_release`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `landlord_apply_release` ;

CREATE TABLE IF NOT EXISTS `landlord_apply_release` (
  `apply_id` INT NOT NULL AUTO_INCREMENT,
  `applyer_id` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `expect_price` DOUBLE NOT NULL,
  `applyer_phone` VARCHAR(45) NOT NULL,
  `applyer_appellation` VARCHAR(15) NOT NULL COMMENT '如何称呼房源发布者',
  `apply_time` TIMESTAMP NOT NULL default current_timestamp,
  `plot_id` INT NOT NULL,
  PRIMARY KEY (`apply_id`),
  INDEX `fk_house_releasing_user1_idx` (`applyer_id` ASC),
  INDEX `fk_landlord_apply_release_plot1_idx` (`plot_id` ASC),
  CONSTRAINT `fk_house_releasing_user1`
    FOREIGN KEY (`applyer_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_landlord_apply_release_plot1`
    FOREIGN KEY (`plot_id`)
    REFERENCES `plot` (`plot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `house_picture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house_picture` ;

CREATE TABLE IF NOT EXISTS `house_picture` (
  `picture_id` INT NOT NULL AUTO_INCREMENT,
  `house_id` INT NOT NULL,
  `picture` BLOB NOT NULL,
  PRIMARY KEY (`picture_id`),
  INDEX `fk_housePicture_house1_idx` (`house_id` ASC),
  CONSTRAINT `fk_housePicture_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`house_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility` ;

CREATE TABLE IF NOT EXISTS `facility` (
  `facility_id` INT NOT NULL AUTO_INCREMENT,
  `facility` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`facility_id`))
ENGINE = InnoDB
COMMENT = '配套设施，如空调、热水器、冰箱、电视等';


-- -----------------------------------------------------
-- Table `house_applyer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house_applyer` ;

CREATE TABLE IF NOT EXISTS `house_applyer` (
  `house_id` INT NOT NULL,
  `house_applyer_id` INT NOT NULL,
  `isSellOn` TINYINT(1) NOT NULL COMMENT '是否在租',
  INDEX `fk_house_tenant_house1_idx` (`house_id` ASC),
  INDEX `fk_house_tenant_user1_idx` (`house_applyer_id` ASC),
  PRIMARY KEY (`house_id`, `house_applyer_id`),
  CONSTRAINT `fk_house_tenant_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`house_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_house_tenant_user1`
    FOREIGN KEY (`house_applyer_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '租客租房关系表';


-- -----------------------------------------------------
-- Table `chat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chat` ;

CREATE TABLE IF NOT EXISTS `chat` (
  `chat_id` INT NOT NULL AUTO_INCREMENT,
  `sender_id` INT NOT NULL,
  `chat_message` TEXT(500) NOT NULL,
  `send_time` DATETIME NOT NULL,
  `agent_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`chat_id`),
  INDEX `fk_chat_agent1_idx` (`agent_id` ASC),
  INDEX `fk_chat_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_chat_agent1`
    FOREIGN KEY (`agent_id`)
    REFERENCES `agent` (`agent_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chat_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `house_facility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `house_facility` ;

CREATE TABLE IF NOT EXISTS `house_facility` (
  `house_id` INT NOT NULL,
  `facility_id` INT NOT NULL,
  `is_exist` TINYINT NOT NULL DEFAULT 0 COMMENT '0代表没有该设施，1代表有',
  INDEX `fk_house_facility_house1_idx` (`house_id` ASC),
  INDEX `fk_house_facility_facility1_idx` (`facility_id` ASC),
  PRIMARY KEY (`house_id`, `facility_id`),
  CONSTRAINT `fk_house_facility_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`house_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_house_facility_facility1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contract`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract` ;

CREATE TABLE IF NOT EXISTS `contract` (
  `contract_id` INT NOT NULL AUTO_INCREMENT,
  `stime` DATE NOT NULL,
  `etime` DATE NOT NULL,
  `tenant_id` INT NOT NULL,
  `house_id` INT NOT NULL,
  PRIMARY KEY (`contract_id`),
  INDEX `fk_contract_user1_idx` (`tenant_id` ASC),
  INDEX `fk_contract_house1_idx` (`house_id` ASC),
  CONSTRAINT `fk_contract_user1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_house1`
    FOREIGN KEY (`house_id`)
    REFERENCES `house` (`house_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '合同';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
