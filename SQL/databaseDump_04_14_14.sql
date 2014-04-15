-- phpMyAdmin SQL Dump
-- version 4.1.8
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Apr 15, 2014 at 01:59 AM
-- Server version: 5.5.34
-- PHP Version: 5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `appdoodah`
--

-- --------------------------------------------------------

--
-- Table structure for table `Activity`
--

USE appdoodah;

CREATE TABLE `Activity` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Cost` varchar(45) DEFAULT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(2) NOT NULL,
  `Zip` varchar(45) NOT NULL,
  `LocationType` varchar(45) NOT NULL,
  `PopularityIndex` varchar(45) DEFAULT NULL,
  `Description` varchar(45) NOT NULL,
  `ActivityDate` datetime NOT NULL,
  `VenueName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Activity`
--

INSERT INTO `Activity` (`Id`, `Name`, `Cost`, `City`, `State`, `Zip`, `LocationType`, `PopularityIndex`, `Description`, `ActivityDate`, `VenueName`) VALUES
(1, 'Grab a Drink', 'Medium', 'New Rochelle', 'NY', '10801', 'Public', '10', 'Usually achieved at a local bar or in the com', '0000-00-00 00:00:00', 'Bar, Home'),
(2, 'Go to the Movies', 'Medium', 'White Plains', 'NY', '10604', 'Public', '9', 'Watch a movie at the theater', '0000-00-00 00:00:00', 'Movie Theater');

-- --------------------------------------------------------

--
-- Table structure for table `Activity_has_Mood`
--

CREATE TABLE `Activity_has_Mood` (
  `Activity_Id` int(11) NOT NULL,
  `Mood_Id` int(11) NOT NULL,
  PRIMARY KEY (`Activity_Id`,`Mood_Id`),
  KEY `fk_Activity_has_Mood_Mood1_idx` (`Mood_Id`),
  KEY `fk_Activity_has_Mood_Activity1_idx` (`Activity_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Favorite`
--

CREATE TABLE `Favorite` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IsFavorite` tinyint(1) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Activity_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`,`User_Id`,`Activity_Id`),
  KEY `fk_Favorite_User1_idx` (`User_Id`),
  KEY `fk_Favorite_Activity1_idx` (`Activity_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Mood`
--

CREATE TABLE `Mood` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Rating`
--

CREATE TABLE `Rating` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Value` varchar(45) DEFAULT NULL,
  `DateCreated` datetime DEFAULT NULL,
  `Comment` varchar(45) DEFAULT NULL,
  `Activity_Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`,`Activity_Id`,`User_Id`),
  KEY `fk_Rating_Activity1_idx` (`Activity_Id`),
  KEY `fk_Rating_User1_idx` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `DateAdded` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `UserPreferences`
--

CREATE TABLE `UserPreferences` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `User_has_Activity`
--

CREATE TABLE `User_has_Activity` (
  `User_Id` int(11) NOT NULL,
  `Activity_Id` int(11) NOT NULL,
  `IsCompleted` tinyint(1) NOT NULL,
  `DateCompleted` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`User_Id`,`Activity_Id`),
  KEY `fk_User_has_Activity_Activity1_idx` (`Activity_Id`),
  KEY `fk_User_has_Activity_User_idx` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `User_has_Mood`
--

CREATE TABLE `User_has_Mood` (
  `User_Id` int(11) NOT NULL,
  `Mood_Id` int(11) NOT NULL,
  `MoodDate` datetime DEFAULT NULL,
  PRIMARY KEY (`User_Id`,`Mood_Id`),
  KEY `fk_User_has_Mood_Mood1_idx` (`Mood_Id`),
  KEY `fk_User_has_Mood_User1_idx` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `User_has_UserPreferences`
--

CREATE TABLE `User_has_UserPreferences` (
  `User_Id` int(11) NOT NULL,
  `UserPreferences_Id` int(11) NOT NULL,
  `Value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`User_Id`,`UserPreferences_Id`),
  KEY `fk_User_has_UserPreferences_UserPreferences1_idx` (`UserPreferences_Id`),
  KEY `fk_User_has_UserPreferences_User1_idx` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Activity_has_Mood`
--
ALTER TABLE `Activity_has_Mood`
  ADD CONSTRAINT `fk_Activity_has_Mood_Activity1` FOREIGN KEY (`Activity_Id`) REFERENCES `Activity` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Activity_has_Mood_Mood1` FOREIGN KEY (`Mood_Id`) REFERENCES `Mood` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Favorite`
--
ALTER TABLE `Favorite`
  ADD CONSTRAINT `fk_Favorite_Activity1` FOREIGN KEY (`Activity_Id`) REFERENCES `Activity` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Favorite_User1` FOREIGN KEY (`User_Id`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Rating`
--
ALTER TABLE `Rating`
  ADD CONSTRAINT `fk_Rating_Activity1` FOREIGN KEY (`Activity_Id`) REFERENCES `Activity` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Rating_User1` FOREIGN KEY (`User_Id`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `User_has_Activity`
--
ALTER TABLE `User_has_Activity`
  ADD CONSTRAINT `fk_User_has_Activity_Activity1` FOREIGN KEY (`Activity_Id`) REFERENCES `Activity` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_has_Activity_User` FOREIGN KEY (`User_Id`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `User_has_Mood`
--
ALTER TABLE `User_has_Mood`
  ADD CONSTRAINT `fk_User_has_Mood_Mood1` FOREIGN KEY (`Mood_Id`) REFERENCES `Mood` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_has_Mood_User1` FOREIGN KEY (`User_Id`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `User_has_UserPreferences`
--
ALTER TABLE `User_has_UserPreferences`
  ADD CONSTRAINT `fk_User_has_UserPreferences_User1` FOREIGN KEY (`User_Id`) REFERENCES `User` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_has_UserPreferences_UserPreferences1` FOREIGN KEY (`UserPreferences_Id`) REFERENCES `UserPreferences` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
