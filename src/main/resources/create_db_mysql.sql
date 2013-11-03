
CREATE TABLE `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `pin1` varchar(45) NOT NULL,
  `pin2` varchar(45) NOT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `contact` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `phone2` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `email2` varchar(45) DEFAULT NULL,
  `wechat` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `group_contact` (
  `group_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`,`contact_id`),
  KEY `group_id_idx` (`group_id`),
  KEY `contact_id_idx` (`contact_id`),
  CONSTRAINT `group_contact_group_id` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `group_contact_contact_id` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE TABLE `avator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file` varchar(45) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `contact_avator` (
  `contact_id` int(11) NOT NULL,
  `avator_id` int(11) NOT NULL,
  PRIMARY KEY (`contact_id`,`avator_id`),
  KEY `contact_id_idx` (`contact_id`),
  KEY `avator_id_idx` (`avator_id`),
  CONSTRAINT `contact_avator_contact_id` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contact_avator_avator_id` FOREIGN KEY (`avator_id`) REFERENCES `avator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)

