-- hotel.profile definition

CREATE TABLE `profile` (
  `profile_id` binary(16) NOT NULL,
  `profile_pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- hotel.`user` definition

CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `profile_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1mcjtpxmwom9h9bf2q0k412e0` (`profile_id`),
  CONSTRAINT `FKof44u64o1d7scaukghm9veo23` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- hotel.staff definition

CREATE TABLE `staff` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `job_role` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hotel.booking definition

CREATE TABLE `booking` (
  `booking_id` binary(16) NOT NULL,
  `ending_date_time` datetime(6) DEFAULT NULL,
  `starting_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- hotel.rooms definition

CREATE TABLE `rooms` (
  `room_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hotel.booking_rooms definition

CREATE TABLE `booking_rooms` (
  `booking_id` binary(16) NOT NULL,
  `room_id` bigint NOT NULL,
  KEY `FKcjk0abrppkbsw5w03uq8tvgfc` (`room_id`),
  KEY `FKe0g8vkaeh304hm4aoqg115bmv` (`booking_id`),
  CONSTRAINT `FKcjk0abrppkbsw5w03uq8tvgfc` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  CONSTRAINT `FKe0g8vkaeh304hm4aoqg115bmv` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- hotel.payment definition

CREATE TABLE `payment` (
  `id` binary(16) NOT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `transaction_id` binary(16) DEFAULT NULL,
  `booking_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqewrl4xrv9eiad6eab3aoja65` (`booking_id`),
  CONSTRAINT `FKqewrl4xrv9eiad6eab3aoja65` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- hotel.services definition

CREATE TABLE `services` (
  `id` binary(16) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;