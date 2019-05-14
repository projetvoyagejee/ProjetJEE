<%-- 
    Document   : footer
    Created on : 9 mai 2019, 15:45:58
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <footer>
        
                    <%-- Vérification de la présence d'un objet utilisateur en session --%>
             <c:choose>
             <c:when test="${!empty sessionScope.sessionUtilisateur}"><p
             class="success">Vous êtes connecté(e) avec l'adresse :
             ${sessionScope.sessionUtilisateur.email}</p></c:when>
             <c:otherwise><p>Vous n'êtes pas connecté(e)</p></c:otherwise>
             </c:choose>
    </footer>
</html>
