# tp de programmation web avancee

## presentation

ce projet met en pratique plusieurs mecanismes de l'api servlet avec java et tomcat : filtres, ecouteurs, sessions http et servlets.


## acces a l'application

une fois tomcat demarre et l'application deployee, le contexte utilise est `TP1_Part2`.

- page de connexion : `http://localhost:8080/TP1_Part2/login.html`
- traitement de la connexion : `/TP1_Part2/LoginServlet` (requete `POST`)
- liste des articles protegee : `http://localhost:8080/TP1_Part2/ListItems`
- informations de session : `http://localhost:8080/TP1_Part2/ShowSession`

pour tester la protection, acceder a `/ListItems` sans etre connecte. le filtre de securite doit rediriger le navigateur vers `login.html`. apres connexion, la liste des articles devient accessible. la page `ShowSession` affiche les informations de la session et permet de se deconnecter.

## le compte rendu pdf

le compte rendu complet et final du tp est disponible dans le fichier **`web_avancee_tp_mohamed_hajji.pdf`**.

le document precedemment depose sur google classroom etait une version non terminee du travail. Merci.