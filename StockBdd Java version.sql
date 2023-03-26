-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 06 mars 2023 à 00:19
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `stockbdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `nomArticle` varchar(20) NOT NULL,
  `stock` smallint(5) UNSIGNED NOT NULL,
  `qteUnite` float NOT NULL,
  `prix` float UNSIGNED NOT NULL,
  `codebarre` varchar(50) NOT NULL,
  `unite` varchar(50) NOT NULL,
  `sousgroupe1` varchar(50) DEFAULT NULL,
  `groupe` varchar(50) NOT NULL,
  `sousgroupe2` varchar(50) DEFAULT NULL,
  `marque` varchar(50) NOT NULL,
  PRIMARY KEY (`codebarre`),
  KEY `unite` (`unite`),
  KEY `sousgroupe` (`sousgroupe1`),
  KEY `groupe` (`groupe`),
  KEY `sousgroupe2` (`sousgroupe2`),
  KEY `marque` (`marque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `categorie` varchar(50) NOT NULL,
  PRIMARY KEY (`categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`categorie`) VALUES
('Alimentaire');

-- --------------------------------------------------------

--
-- Structure de la table `codebarre`
--

DROP TABLE IF EXISTS `codebarre`;
CREATE TABLE IF NOT EXISTS `codebarre` (
  `codebarre` varchar(50) NOT NULL,
  `qteArticle` smallint(5) UNSIGNED NOT NULL,
  `prixLot` float UNSIGNED NOT NULL,
  `refcodebarre` varchar(50) NOT NULL,
  PRIMARY KEY (`codebarre`),
  KEY `refcodebarre` (`refcodebarre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `groupe` varchar(50) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  PRIMARY KEY (`groupe`),
  KEY `categorie` (`categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`groupe`, `categorie`) VALUES
('Boisson', 'Alimentaire'),
('Confisserie', 'Alimentaire'),
('Conserve', 'Alimentaire'),
('Epice', 'Alimentaire'),
('Epicerie salé', 'Alimentaire'),
('Epicerie sucré', 'Alimentaire'),
('Fruit légume', 'Alimentaire'),
('Produit laitier et frais', 'Alimentaire'),
('Surgelé', 'Alimentaire'),
('Viande', 'Alimentaire');

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

DROP TABLE IF EXISTS `marque`;
CREATE TABLE IF NOT EXISTS `marque` (
  `marque` varchar(50) NOT NULL,
  PRIMARY KEY (`marque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sousgroupe`
--

DROP TABLE IF EXISTS `sousgroupe`;
CREATE TABLE IF NOT EXISTS `sousgroupe` (
  `sousgroupe` varchar(50) NOT NULL,
  `groupe` varchar(50) NOT NULL,
  PRIMARY KEY (`sousgroupe`),
  KEY `groupe` (`groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sousgroupe`
--

INSERT INTO `sousgroupe` (`sousgroupe`, `groupe`) VALUES
('Alcool', 'Boisson'),
('Eau', 'Boisson'),
('Jus de fruit', 'Boisson'),
('Lait', 'Boisson'),
('Soda', 'Boisson'),
('Féculent', 'Epicerie salé'),
('Huile', 'Epicerie salé'),
('Olives', 'Epicerie salé'),
('Sauces/Condiment', 'Epicerie salé'),
('Gateau', 'Epicerie sucré'),
('Pâte à tartiner', 'Epicerie sucré'),
('Thé/café/Tisane', 'Epicerie sucré'),
('Fruit/Légume Frais', 'Fruit légume'),
('Fruit/Légume Sec', 'Fruit légume'),
('Fromage', 'Produit laitier et frais'),
('Pâte fraîche', 'Produit laitier et frais'),
('Yogourt', 'Produit laitier et frais');

-- --------------------------------------------------------

--
-- Structure de la table `unite`
--

DROP TABLE IF EXISTS `unite`;
CREATE TABLE IF NOT EXISTS `unite` (
  `Unite` varchar(10) NOT NULL,
  PRIMARY KEY (`Unite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `unite`
--

INSERT INTO `unite` (`Unite`) VALUES
('Gramme'),
('Kilogramme'),
('Litre');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `idVente` bigint(20) NOT NULL AUTO_INCREMENT,
  `idArticle` varchar(50) NOT NULL,
  `prix` float UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idVente`),
  KEY `idArticle` (`idArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`unite`) REFERENCES `unite` (`Unite`),
  ADD CONSTRAINT `article_ibfk_2` FOREIGN KEY (`sousgroupe1`) REFERENCES `sousgroupe` (`sousgroupe`),
  ADD CONSTRAINT `article_ibfk_3` FOREIGN KEY (`groupe`) REFERENCES `groupe` (`groupe`),
  ADD CONSTRAINT `article_ibfk_4` FOREIGN KEY (`sousgroupe2`) REFERENCES `sousgroupe` (`sousgroupe`),
  ADD CONSTRAINT `article_ibfk_5` FOREIGN KEY (`marque`) REFERENCES `marque` (`marque`);

--
-- Contraintes pour la table `codebarre`
--
ALTER TABLE `codebarre`
  ADD CONSTRAINT `codebarre_ibfk_1` FOREIGN KEY (`refcodebarre`) REFERENCES `article` (`codebarre`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`categorie`);

--
-- Contraintes pour la table `sousgroupe`
--
ALTER TABLE `sousgroupe`
  ADD CONSTRAINT `sousgroupe_ibfk_1` FOREIGN KEY (`groupe`) REFERENCES `groupe` (`groupe`);

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`idArticle`) REFERENCES `article` (`codebarre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
