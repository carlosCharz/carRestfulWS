--
-- Servidor: localhost
-- Tiempo de generación: 09-11-2014 a las 19:18:48
-- Versión del servidor: 5.5.25a
-- Versión de PHP: 5.4.4

--
-- Base de datos: `car_app`
--

CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(200) NOT NULL,
  `year` int(11) NOT NULL,
  `manufacturer` varchar(200) NOT NULL,
  `country` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

INSERT INTO `car` (`id`, `model`, `year`, `manufacturer`, `country`) VALUES
(1, 'Yaris', 2013, 'Toyota', 'Japan'),
(2, 'Rio Hatchback', 2014, 'Kia', 'Korea'),
(3, 'i30', 2012, 'Hyundai', 'Korea'),
(4, 'Sportage', 2013, 'Kia', 'Korea'),
(5, 'Sail', 2014, 'Chevrolet', 'USA');
