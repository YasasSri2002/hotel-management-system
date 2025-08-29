ALTER TABLE booking Add COLUMN status varchar(255);

-- hotel.booking_services definition

CREATE TABLE `booking_services` (
  `booking_id` binary(16) NOT NULL,
  `services_id` binary(16) NOT NULL,
  KEY `FKina0onelx8dx105xuji0hhqlh` (`services_id`),
  KEY `FK96s1e9neeevdkrc0uir5rbsgx` (`booking_id`),
  CONSTRAINT `FK96s1e9neeevdkrc0uir5rbsgx` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `FKina0onelx8dx105xuji0hhqlh` FOREIGN KEY (`services_id`) REFERENCES `services` (`services_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;