<%-- 
    Document   : accueil
    Created on : 14 mai 2019, 10:26:58
    Author     : stagldnr
--%>

<c:choose>
    <c:when test="${!empty sessionScope.sessionUtilisateur && sessionScope.sessionUtilisateur.id_User==1}">
        <div id="header">
            <h1 id="nomSite">Oh My Blog!</h1>
            <a href="accueil" id="accueil">Accueil</a>

            <a href="deconnection" id="deconnection">Deconnection</a>
            <nav id="menuHeader">
                <div id="divMenu">
                    <a href="galerie" id="galerie">Galerie photos</a>
                    <a href="destination" id="destination">Destination</a> 
                    <a href="cuisine" id="cuisine">Variété cullinaire</a> 
                </div>
            </nav>
            <nav id="menuAdmin">
                <div id="divMenu">
                    <a href="creationPost" id="creationPost">Creer un Post</a>
                    <a href="listPost" id="listPost">Liste des Posts</a>
                    <a href="listeBestPost" id="listeBestPost">Top 3</a>
                    <a href="listecom" id="listecom">Signalements</a>
                    <a href="listeinscrit" id="listeinscrit">Liste des inscrits</a>
                </div>
            </nav>
    </c:when>
    <c:when test="${!empty sessionScope.sessionUtilisateur && sessionScope.sessionUtilisateur.id_User!=1}">
        <div id="header">
            <h1 id="nomSite">Oh My Blog!</h1>
            <a href="accueil" id="accueil">Accueil</a>
            <a href="deconnection" id="deconnection">Deconnection</a>
            <nav id="menuHeader"> 
                <div id="divMenu">
                    <a href="galerie" id="galerie">Galerie photos</a>
                    <a href="destination" id="destination">Destination</a> 
                    <a href="cuisine" id="cuisine">Variété cullinaire</a> 
                </div> 
            </nav>
        </div>
    </c:when>

    <c:otherwise>
        <div id="header">
            <h1 id="nomSite">Oh My Blog!</h1>
            <a href="accueil" id="accueil">Accueil</a>
            <a href="connection" id="connection">Connexion</a>
            <a href="inscription" id="inscription">Inscription</a>
            <nav id="menuHeader"> 
                <div id="divMenu">
                    <a href="galerie" id="galerie">Galerie photos</a>
                    <a href="destination" id="destination">Destination</a> 
                    <a href="cuisine" id="cuisine">Variété cullinaire</a> 
                </div> 
            </nav>
    </c:otherwise>

</c:choose>

