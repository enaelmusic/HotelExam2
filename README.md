# Question Exam OO -EAFCEVERE
voici une resolution de l'énnoncé suivant 
## ennoncé
Consignes :
- Pas de documentation et/ou papiers autres que ceux distribués par l’enseignant
- Pas de téléphone, tablette ou autres objets connectés (montres...)
- Pas d’accès Internet, sauf accès Teams pour transfert du fichier
- La partie « pratique » se fait sur l’ordinateur qui vous est assigné par l’enseignant
- Utilisation IA interdite (chatGPT...)
- Les classes doivent être réutilisables (pas de lambdas !)


Créez une application type console avec le logiciel Eclipse en suivant scrupuleusement les étapes ci-dessous.
Nous allons modéliser les premières étapes d’un logiciel de gestion d’hôtel.

Une chambre/suite comporte un identifiant unique, un étage, une catégorie (LUXE, GRAND_LUXE, IMPERIAL), 
un nombre maximum de personnes et une description.
Chaque chambre/suite peut accueillir des personnes. Chaque personne est identifiée par un numéro de registre national, un nom, un prénom et une date de naissance.
La « Map » est imposée comme structure de données pour les chambres et personnes.

L’utilisateur doit pouvoir ajouter des chambres.
Une personne doit pouvoir être ajouté à une chambre déjà existante.
Une exception ChambreFullException doit être lancée si on essaie d’ajouter plus de personnes que le montant maximum par chambre.
L’hôtel doit pouvoir fournir le nombre de personnes.
L’hôtel doit pouvoir donner la liste des personnes, triées par chambre ou trié par nom de famille. L’hôtel doit pouvoir donner la liste des personnes qui ont moins de 18 ans, triée par nom de famille.

Créez un Singleton utilitaires qui imprime à la console les différents retours de méthodes. Commentez (JavaDoc) uniquement les éléments qui font de votre classe un Singleton.
Créez une classe Test (JUnit) et testez que votre Singleton est bien un Singleton (une seule méthode à tester).

Le prof souhaite entrainné sur l'utilisation de collection SET ou MAP

## focus on object use
on focus sur la manipulation d'objet, il y a plusieur facon de configurer les paramètre d'objet.

<a href=""> rédigez une issue</a> si vous rencontrez un probleme.
