CREATE TABLE `security_user`(
  `id` binary(16) NOT NUll,
  `username` varchar(255) DEFAULT NUll,
  `password` varchar(255) DEFAULT Null,
  `role` varchar(100) DEFAULT NUll,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `client` DROP COLUMN `password`;