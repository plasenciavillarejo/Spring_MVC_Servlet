package scripts;

public class Custom_bbdd_springSecutity {
	// Crear tabla de Usuarios
	CREATE TABLE `Usuarios` (
		`cuenta` varchar(100) NOT NULL,
		`pwd` varchar(100) NOT NULL,
		`activo` tinyint(1) NOT NULL,
		`email` varchar(100) NOT NULL,
		`telefono` varchar(50) NOT NULL,
		PRIMARY KEY (`cuenta`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	// Crear tabla de Perfiles
	CREATE TABLE `Perfiles` (
		`cuenta` varchar(100) NOT NULL,
		`perfil` varchar(70) NOT NULL,
		UNIQUE KEY `authorities_idx_2` (`cuenta`,`perfil`),
		CONSTRAINT `authorities_ibfk_2`
		FOREIGN KEY (`cuenta`)
		REFERENCES `Usuarios` (`cuenta`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	// Insertamos nuestros usuarios
	INSERT INTO `Usuarios` VALUES ('luis','{noop}luis123',1,'luis@test.com','9856523');
	INSERT INTO `Usuarios` VALUES ('marisol','{noop}mari123',1,'marisol@example.com','9856482');

	// Insertamos (asignamos roles) a nuestros usuarios.
	INSERT INTO `Perfiles` VALUES ('luis','EDITOR');
	INSERT INTO `Perfiles` VALUES ('marisol','GERENTE');
}
