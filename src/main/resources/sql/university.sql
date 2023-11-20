DROP SCHEMA IF EXISTS `university`;
CREATE SCHEMA `university`;
USE `university`;

CREATE TABLE `lector` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(250) NOT NULL UNIQUE,
    `degree` ENUM('assistant', 'associate professor', 'professor') NOT NULL,
    `salary` DECIMAL(10,2) DEFAULT 0.00,
	PRIMARY KEY (`id`)
);

CREATE TABLE `department` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(250) NOT NULL UNIQUE,
	`head` VARCHAR(250),
	PRIMARY KEY (`id`),
    CONSTRAINT `head_fk` 
		FOREIGN KEY (`head`) 
		REFERENCES `lector` (`name`)
        ON DELETE SET NULL
);

CREATE TABLE `department_lector` (
	`department_id` INT NOT NULL,
	`lector_id` INT NOT NULL,
	PRIMARY KEY (`department_id`, `lector_id`),
    CONSTRAINT `department_id_fk` 
		FOREIGN KEY (`department_id`) 
		REFERENCES `department` (`id`)
        ON DELETE CASCADE,
	CONSTRAINT `lector_id_fk` 
		FOREIGN KEY (`lector_id`) 
		REFERENCES `lector` (`id`)
        ON DELETE CASCADE
);