CREATE TABLE IF NOT EXISTS `ODONTOLOGOS` (
	`id` int AUTO_INCREMENT NOT NULL UNIQUE,
	`matricula` int NOT NULL,
	`nombre` varchar(100) NOT NULL,
	`apellido` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

