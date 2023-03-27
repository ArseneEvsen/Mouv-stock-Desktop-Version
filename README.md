# Stock Management - Desktop Version
Auteur : Evsen Arsène

Technologies : Java / Swing / JDBC

## Sommaire :
- Présentation
- Fonctionnalitées
- Prérequis
- Comment se procurer l’application + méthode d’installation
- Licence

## Présentation
Dans le cadre de mon stage dans un supermarché, j'ai développé un logiciel de gestion de stock. Cette application est la version desktop en Java qui est **totalement fonctionnelle**. 
Pour plus d'information et une meilleure présentation du contexte, le rapport de stage est disponible en téléchargement dans ce repository.

## Fonctionnalitées
L'application de gestion de stock a plusieurs fonctionnalitées, pouvant être regroupé en quatre menus, notamment :
- Menu stock
- Menu création
- Menu vente
- Menu recherche

### Menu stock :
Le menu stock permet de gérer les entrées et sorties de produits en stocks.

> **_NOTE:_**
Dans ce projet, il y a une distinction entre les produits unitaires et les produits en lots, tout deux représenté par des code-barres. Ceci afin d'éviter des bugs au niveau du stock et de l'historique de vente, en base de donnée. Pour plus de précision, veuillez consulter le rapport de stage.

IHM du choix d'action : ajouter ou retirer du stock :

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20Stock.PNG?raw=true)

IHM de l'ajout d'un produit :
Le programme attend la saisie du **code-barre** du produit à ajouter en stock.
Si le code-barre saisie désigne un **lot de produit**, alors le stock du produit unitaire concerné est incrémenté.
Si le produit n'existe pas en base de donnée, l'utilisateur est prévenu.

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20Stock_ajout.PNG?raw=true)

L'IHM pour retirer du stock est exactement le même, cependant le processus est inversé.
### Menu création :
Afin que l'application puisse fonctionner correctement, il est nécessaire que les produits soient identifiés en base de donnée, à l'aide de leurs code-barres uniques. 
Tout les articles ont des caractéristiques communs : marque, groupe/sous-groupe ect...

Le menu création permet d'enregister les articles pour la première fois en base de donnée, mais aussi de créer des marques/groupe/sous-groupes... Pour qu'ils puissent être réutilisés, au moment de la création d'articles.

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20cr%C3%A9ation.PNG?raw=true)

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20cr%C3%A9ation_choix%20article.PNG?raw=true)

Choix de la création d'un article de lot : 

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20cr%C3%A9ation_choix%20article_Lot.PNG?raw=true)

Choix de la création d'un article unitaire : 

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20cr%C3%A9ation_choix%20article_unitaire.PNG?raw=true)

Création de marques/groupe/sous-groupes :

![Alt Text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20cr%C3%A9ation_choix%20marquegroupeect.PNG?raw=true)

### Mode vente
Le mode vente, utilisable par les employés en caisse, est une IHM qui à la saisie d'un code-barre va : 
- Identifier si l'article scannée est unitaire ou en lot
- Si l'article est de type lot, il va récupérer son prix et la quantité associé pour créer une **transaction de vente** et **retirer du stock** de l'article unitaire référé la quantité.

![alt text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Mode%20Vente.PNG?raw=true)

> **_NOTE:_**
L'employé n'a pas à se soucier d'indiquer au logiciel quand sa saisie de code-barre est terminé. L'IHM exécute le traitement au bout **d'1.5 secondes d'inactivité** de saisie après le début d'une saisie.
Cela permet à l'employé d'enchainer les scans de produits en caisse.

#### Menu recherche :
Le menu recherche permet de retrouver et d'afficher les caractéristiques associés à un produit après la saisie du code-barre de ce dernier.

![alt text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20Recherche.PNG?raw=true)

![alt text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20Recherche_%20Article_Lot.PNG?raw=true)

![alt text](https://github.com/ArseneEvsen/Stock-Management-Desktop-Version/blob/master/Screen%20V1/Menu%20Recherche%20article%20unitaire.PNG?raw=true)



## Prérequis
- Eclipse Version: 2022-06 (4.24.0)
- java.runtime.version=17.0.4.1+1
- Les drivers (exemple : mysqlconnector) sont disponibles dans le repository.
- Base de donnée MySql Version 8
- Logiciel de gestion et d'administration de bases de données MySQL favoris (exemple : MySQL Workbench)

## Comment se procurer l'application + méthode d'installation
- Télécharger le fichier "GestionStock".
- Décompresser le fichier téléchargé
- Avec l'IDE Eclipse 2022-06, ouvrir l'application avec le dossier décompressé à l'aide du menu "import"
- Ouvrir MySql Workbench, déployer la base de donnée
- Avec l'adresse localhost, l'identifiant "admin" et "mot de passe", configurer le fichier ConnexionMySQL téléchargé dans le projet.
- La classe de à exécuter en premier se trouve dans view->MainWindow

## Licence 
MIT License

Copyright (c) [year] [fullname]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
