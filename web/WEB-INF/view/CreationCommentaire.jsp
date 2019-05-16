<%-- 
    Document   : CreationPost
    Created on : 14 mai 2019, 15:49:11
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Creation d'un Commentaire</title>
        <link type="text/css" rel="stylesheet" href="inc/form.css" />
    </head>
    <body>
        <form method="get" action="creationPost">
            <fieldset>
                <legend>Creation d'un commentaire</legend>
                <p>Vous pouvez creer un commentaire ici.</p>
                <label for="title">Commentaire <span
                        class="requis">*</span></label>
                <input type="text" id="title" name="title" value="<c:out
                           value="${commentaire.id_commentaire}"/>"  />
                
                <br /><label for="body">Corps de votre commentaire <span
                        class="requis">*</span></label>
                <input type="text" id="body" name="body"
                       value="<c:out value="${commentaire.contenu}" />" />
              
            </fieldset>
        </form>
               <c:import url="/WEB-INF/template/footer.jsp"/>
    </body>
</html>

