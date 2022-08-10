SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `author` (
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `author` (`name`, `id_book`) VALUES
('Johnny', 10),
('Tuan Kiet', 11),
('DeepFry', 11);

CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `director` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `artist` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ;

INSERT INTO `media` (`id`, `title`, `category`, `cost`, `length`, `director`, `artist`, `product`) VALUES
(0, 'Totoro', 'Anime', 250, 1000, 'Miyazaki', NULL, 'DVD'),
(1, 'Mononoke', 'Anime', 130, 430, 'Suzuki', NULL, 'DVD'),
(2, 'Dead or Alive', 'Action', 120, 1235, 'John', NULL, 'DVD'),
(3, 'Tom and Jerry', 'Animation', 100, 255, 'Mike', NULL, 'DVD'),
(4, 'Gia dinh', 'Film', 90, 400, 'Van Minh', NULL, 'DVD'),
(5, 'Final week', 'Action', 550, 560, 'Jack', NULL, 'DVD'),
(6, 'Hoc C', 'Learn', 420, 900, 'Minh Quan', NULL, 'DVD'),
(7, 'C++ tot hon C', 'Learn', 1000, 390, 'Tuan Kiet', NULL, 'DVD'),
(8, 'Do and Do', 'Action', 80, 900, 'Johnson', NULL, 'DVD'),
(9, 'Winning', 'Learn', 800, 390, 'Tuan Kiet', NULL, 'DVD'),
(10, 'Learn C', 'Learn', 1000, NULL, NULL, NULL, 'Book'),
(11, 'How to get taller', 'Biological', 2000, NULL, NULL, NULL, 'Book'),
(12, 'Dem He', 'Bolero', 240, 500, 'Quang Le', 'Quang Le', 'CD'),
(13, 'Cam on', 'Bolero', 350, 500, 'Paris by Night', 'Duy Khanh', 'CD'),
(14, 'Vong nhan cuoi', 'Bolero', 100, 500, 'Paris by Night', 'Manh Quynh', 'CD'),
(15, 'No', 'Bolero', 190, 500, 'Quang Le', 'Quang Le', 'CD'),
(16, 'Me toi', 'Bolero', 400, 500, 'Manh Quynh', 'Manh Quynh', 'CD'),
(17, 'No va toi', 'Bolero', 200, 500, 'Truong Vu', 'Truong Vu', 'CD');

CREATE TABLE `orders` (
  `customer_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_media` int(11) DEFAULT NULL,
  `cost` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `track` (
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `id_cd` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `track` (`title`, `length`, `id_cd`) VALUES
('Dem he', 500, 12),
('Cam on', 500, 13),
('Vong nhan cuoi', 500, 14),
('No', 500, 15),
('Me toi', 500, 16),
('No va toi', 500, 17);


CREATE TABLE `users` (
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `money` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `users` (`username`, `password`, `name`, `money`) VALUES
('20194599', 'e10adc3949ba59abbe56e057f20f883e', 'Vu Tuan Kiet', 2000),
('minhtruong123', '05477428b47c5d642a5567609b9290dd', 'Ngo Minh Truong', 2000);

CREATE TABLE `card` (
  `card` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `money` int(11) NOT NULL,
  `isused` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `card` (`card`, `money`, `isused`) VALUES
('0983455561', 3200, 0),
('0987654321', 3000, 0),
('1128983321', 1500, 0),
('1234567890', 2000, 0),
('1923443638', 500, 0),
('1983122638', 2500, 0),
('1988273638', 1000, 0),
('2282113638', 1200, 0),
('9961654321', 2200, 0);

ALTER TABLE `author`
  ADD KEY `fk_author_book` (`id_book`);

ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `orders`
  ADD KEY `fk_cusname_name` (`customer_name`),
  ADD KEY `fk_idmedia_id` (`id_media`);

ALTER TABLE `track`
  ADD KEY `fk_track_cd` (`id_cd`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

ALTER TABLE `author`
  ADD CONSTRAINT `fk_author_book` FOREIGN KEY (`id_book`) REFERENCES `media` (`id`);

ALTER TABLE `orders`
  ADD CONSTRAINT `fk_cusname_name` FOREIGN KEY (`customer_name`) REFERENCES `users` (`username`),
  ADD CONSTRAINT `fk_idmedia_id` FOREIGN KEY (`id_media`) REFERENCES `media` (`id`);

ALTER TABLE `track`
  ADD CONSTRAINT `fk_track_cd` FOREIGN KEY (`id_cd`) REFERENCES `media` (`id`);
COMMIT;