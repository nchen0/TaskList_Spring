USE `todolist`;

LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES 
	(1,'David'),
	(2,'John'),
	(3,'Ajay');

UNLOCK TABLES;