<%-- 
    Document   : adminheader
    Created on : 13 mai 2019, 14:50:12
    Author     : stagldnr
--%>



<div id="header">
    <h1 id="nomSite">Oh My Blog!</h1>
    <a href="accueil" id="accueil">Accueil</a>
    <a href="connection" id="connection">Connexion</a>
    <a href="inscription" id="inscription">Inscription</a>
    <c:if test="${!empty sessionScope.sessionUtilisateur && sessionScope.sessionUtilisateur.id==1}">
         
    <nav id="menuHeader">
        <div id="divMenu">
             <a href="creationPost">Creer un Post</a>
             <a href="listPost">Liste des Posts</a>
             <a href="listeBestPost">Top 3</a>
             <a href="listecom">Liste commentaire signalés</a>
             <a href="listeinscrit">Liste des inscrits</a>
        </div>
    </nav>
</c:if>
</div>
