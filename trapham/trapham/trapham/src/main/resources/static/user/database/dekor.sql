-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2020 at 06:21 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dekor1`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `ad_ID` int(11) NOT NULL,
  `Address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`ad_ID`, `Address`) VALUES
(1, 'Hà Nội'),
(2, 'Bắc Ninh'),
(3, 'Hải Phòng'),
(4, 'Đà Nẵng');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `ID_C` int(255) NOT NULL,
  `id_user` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_product` int(255) NOT NULL,
  `quantity` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Name`, `Password`) VALUES
(31, 'vanvan', '12345'),
(32, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_ID` int(11) NOT NULL,
  `p_Name` varchar(40) NOT NULL,
  `category` varchar(40) NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(10000) NOT NULL,
  `picture` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_ID`, `p_Name`, `category`, `price`, `description`, `picture`) VALUES
(1, 'Linen Shirt With Mao Color', 'CHAIR', 59, 'Linen Shirt With Mao Color - a wonderful product designed by Eames has always had a strange charm and spread, from famous interior magazines to luxury hotel restaurants or upper-class families. you can all come across.', 'shop1.jpg'),
(2, 'Superdry Shirt With Wash', 'CHAIR', 30, 'The luxurious and classy Superdry Shirt With Wash seats are always the first choice for home dining spaces. With beautiful design, comfortable sitting posture, solid structure, Velvet chairs are also used flexibly in many other interior spaces such as restaurants, cafes, lounges.', 'shop2.jpg'),
(3, 'Arvust Shirt In Washed Blue', 'BOOK', 45, 'Leaders are constantly talking about how we should read, what, when and how much. Some people suggest that you read one book a day if you want to be successful, however, the bottom line is: Read as much as possible.', 'shop3.jpg'),
(4, 'Phasellus mattis eros', 'ACCESSORIE', 20, 'The bell is suitable for hanging on long distance animals without obstacles. Often used as decorations, bells for Christmas season, bells are also used to hang on dogs, goats, and sheep to signal. Or used to hang the door to notify visitors to the house.', 'shop4.jpg'),
(5, 'Proin sit amet ultrices', 'SOFA', 100, 'Proin sit amet ultrices sofa products are designed to exactly meet the requirements of a modern living room. With a design to fit in the corner of the room to optimize the area while ensuring the aesthetics and elegance of the entire room.', 'shop5.jpg'),
(6, 'Aenean magna lorem', 'CHAIR', 60, 'Office swivel chair is one of the modern and convenient chair lines for office spaces. The chair has many modes that make it easier to use. The adjustable height is an advantage that fixed leg and chair legs do not have. At the same time, the chair can be used flexibly.', 'shop6.jpg'),
(7, 'Edlyn Chaise Sectional', 'SOFA', 150, 'Why We Love It.\r\nThe neat proportions of a modern Italian shape, reimagined with fiber-padded cushions, minimalist legs and a gently reclining back.', 'shop7.jpg'),
(8, 'Wool Edlyn Bench', 'SOFA', 50, 'Featuring neat proportions of a modern Italian shape reimagined with fiber-padded wool, this bench offers a cozy seat for anywhere in your home.\r\nFor ordering assistance and more, please contact us. For aesthetic advice and tips to help decorate your space, enjoy our complimentary home styling services.', 'shop8.jpg'),
(9, 'Edlyn Chaise1', 'SOFA', 66, 'Boasting clean lines and a neatly proportioned seat, this inviting respite is inspired by modern Italian design, complete with down-wrapped cushions, brass legs, and a gently reclining back.', 'shop9.jpg'),
(10, 'Edlyn Chaise2', 'SOFA', 99, 'Boasting clean lines and a neatly proportioned seat, this inviting respite is inspired by modern Italian design, complete with down-wrapped cushions, brass legs, and a gently reclining back.', 'shop10.jpg'),
(11, 'Lemieux et Cie Perou Chair', 'SOFA', 44, 'With a thick, supportive seat and a modern wingback silhouette, this chair offers a design that is modern enough to make a design accent, yet cozy enough to sink into with a good book.', 'shop11.jpg'),
(12, 'Chamomile leather upholstery', 'CHAIR', 30, 'Chamomile leather upholstery, high-quality leather upholstery, oak legs with good 3D design suitable for many spaces and styles of dining room and living room. And suitable for square, round, rectangular table. Size: 47 * 53 * 81', 'shop12.jpg'),
(13, 'Brocade wooden leg coffee chair', 'CHAIR', 66, 'Brocade wooden leg coffee chair designed by Ray and Chaler couple. This chair model is so popular with many people that everywhere you can accidentally see its image from the office, the cafeteria, or the family. Armrest backrest. removable, easy to transport. Size: 55 * 60 * 81', 'shop13.jpg'),
(14, 'The  0.8m tulip coffee table', 'ACCESSORIE', 120, 'The 0.8m tulip coffee table is one of the favorite models of a coffee table or reception desk. With elegant design, youthful modern white color and round face with radius of 80cm. Table pillars attached to the legs create a solid posture. Compact, easy to put in many different positions. Very suitable for showrooms, reception desks, ..', 'shop14.jpg'),
(15, 'TV Shelves Wall Mounted 2 Drawers', 'ACCESSORIE', 200, 'The design is simple but sharp, the edges are soft, the paint is smooth and modern, making the home decoration more impressive to save the area.\r\nSet shelf suitable for TV from 39 to 51icnh, bearing up to 15kg for receiver, Wifi, speakers, electrical equipment comfortably.', 'shop15.jpg'),
(16, 'Wall Shelf', 'ACCESSORIE', 45, 'Wall-mounted shelves with simple design are spacious, airy, not fussy, easy to decorate in the room. \r\nVery suitable for living room bedroom. Can store books, decorations, ...', 'shop16.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `ID` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `address` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `discription` varchar(200) NOT NULL,
  `img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`ID`, `firstname`, `lastname`, `email`, `telephone`, `address`, `pass`, `discription`, `img`) VALUES
(31, 'Vân', 'Vân', 'vanvan@gmail.com', '0999999999', 'Hà Nội', '12345', 'Cô vân xinh gái! haha', 'team1.jpg'),
(32, 'admin', '', 'admin', '012345677', 'Bắc Ninh', 'admin', 'Bad Boy', '404.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ad_ID`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID_C`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_ID`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `ad_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `ID_C` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `register` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
