# maCave [![Build Status](https://travis-ci.org/valmart/maCave.svg?branch=master)](https://travis-ci.org/valmart/maCave)

Cavavin
Février 2016
PARIS
CAHIER DES CHARGESRésumé du document










	Ce cahier des charges vise à définir exhaustivement les spécification de base de
mon projet Cavavin.Description du document




Historique des versions


Table des matières
1. Rappel du projet	1
2. Environnement de réalisation	1
a. Environnement de travail	1
b. Architecture technique	2
c. Composants existants	2
3. Parties du site web à réaliser	3
a. Utilisateur non connecté sur le site	3
b. Inscription au service	3
c. Utilisateurs connectés	31. Rappel du projet
Principe de base du projet

Le but du projet « Cavavin » est de proposer un service de gestion de cave à vin en ligne. L’utilisateur pourra savoir combien de bouteilles se trouvent dans sa cave et obtenir différentes informations sur les bouteilles grâce à un QR code généré par le site et ensuite accolée à la bouteille.

2. Environnement de réalisation
a. Environnement de travail

	Afin de mener à bien ce projet j’utiliserais différents outils représentants mon environnement de travail.

	Gestion de versions

	J’utiliserais GIT afin de gérer les différentes versions du projet. De plus cela facilitera la mise 	en production ainsi que les possibles évolutions futures du projet. Git est le système de 		gestion de version le plus couramment utilisé et je m’en suis déjà servis à de nombreuses 		reprises, notamment au sein d’Epitech.

	Mon projet sera hébergé sur GitHub. J’ai choisi Github car ainsi les sources seront publiques 	et pourrons être consultées, par exemple, par des recruteurs.

	Le dépôt Git contiendra trois branches :
Master : branche de production. Contiendra la dernière version stable du projet.
Pre-prod : branche où seront effectués les tests avant d'envoyer sur la production.
Développement : branche où je développerais le projet.

	Le dépôt git est disponible à l’adresse suivante : https://github.com/valmart/maCave




	Edition de code

	J’utiliserais IntelliJ pour développer l’application. Ce dernier comprend de nombreux plugins compatibles avec Play! Framework, html, css, js… Moins « encombrant » et complexe qu’Eclipse, IntelliJ me semble est l’IDE parfait pour ce projet.


b. Architecture technique

	Structure du site web
	Le site sera construit sur une architecture MVC.
	Le vues seront réalisé en HTML5/CSS3. Certaines parties des vues seront générées grâce à du Scala. La bibliothèque Bootstrap sera très largement utilisée afin de rendre le site responsive. Quelques fonctionnalité seront aussi développées en Javascript/jQuery. Le back de l’application sera développé en Java grâce au framework Play!.

	Base de donnée

	La BDD est l’endroit où seront stockées toutes les informations nécessaires au projet.
Mon choix de système de gestion de base de données s’est arrêté sur PostgreSQL. J’ai été séduit par ses performances, ses fonctions internes exclusives et son côté à la fois relationnel et objet. De plus je l’ai déjà utilisé, notamment au cours de mon EIP.

	Serveur d’intégration continue
	Afin de tester la validité de l’application à chaque modification un serveur d’intégration continue à été mis en place. J’ai choisi d’utiliser Jenkins à cause de sa grande compatibilité avec github. Ainsi a chaque nouveau push Jenkins test si l’application est toujours fonctionnelle et affiche le résultat sur la page du dépôt git.

c. Composants existants

	Je décris ici les cas de réutilisation de composants déjà existants sur lesquels je me baserais pour la réalisation du projet.

Play! Framework

	Play! est un framework Web pour Java et Scala permettant le développement d’applications facilement scalables. Il offre de bonnes performances et de nombreuses fonctionnalitées. De plus je l’ai déjà utilisé au cours d’un de mes stages.

	plus d’infos : https://playframework.com/


3. Parties du site web à réaliser
	Dans ce chapitre, je vais détailler les différentes parties du programme à réaliser.
Afin que le site soit agréable d'utilisation et donne envie aux utilisateurs de rester, il est important que l'ergonomie soit la meilleure possible et que toutes les pages soit visibles aussi bien sur mobile que sur tablette ou pc.

	a. Utilisateur non connecté sur le site

	Les visiteurs sont invités à s’inscrire depuis la page d’accueil du site.

	L’utilisateur pourra aussi choisir de se connecter (depuis cette page ou la page dédiée).

	b. Inscription au service

	Pour s’inscrire l’utilisateur devra fournir :
		- une adresse mail
		- un mot de passe

	Le formulaire d’inscription est volontairement minime afin d’inciter les visiteurs à s’inscrire.

	c. Utilisateurs connectés

	Page d’accueil pour les utilisateurs

	Chaque fois que l’utilisateur se connecte au site il arrive sur la page d’accueil de sa cave (une seule cave par utilisateurs).
Celle ci comprend une partie « récapitulatif » comprenant le nombre de bouteilles dans la case, le nombre de bouteilles de chaque type de vin, un résumé dé l’activité de la cave et le QR code (imprimable de la cave). Le QR code permet, une fois imprimé et scanné, d’arriver directement sur cette page.
La seconde partie de cette page est composé de la liste de toutes les bouteilles classées par type de vin.
Il est également possible depuis cette page d’accéder aux listes de bouteilles disponibles par type de vin ainsi que l’historique des bouteilles.
En cliquant sur une bouteille dans une liste l’utilisateur est redirigé vers la page « détails » de cette bouteille.

	Détails des bouteilles

	L’utilisateur peut voir les détails concernant chaque bouteille ainsi qu’imprimer le QR code correspondant depuis cette page. Il peut aussi indiquer si cette bouteille à été ouverte ou offerte. C’est également sur cette page que l’utilisateur arrive lorsqu’il scanne le QR code d’une bouteille.

	Déconnexion
	En cliquant sur ce bouton l’utilisateur est déconnecté et renvoyé sur la page d’accueil.

	Ajout de bouteilles
	Depuis cette page l’utilisateur peut ajouter une/des bouteille(s) à sa cave. Il doit pour cela rentrer plusieurs informations sur la bouteille (domaine, appellation, millésime…)

	Listes de bouteilles
	Plusieurs pages sont composées de listes de bouteilles (liste de rouge, …)