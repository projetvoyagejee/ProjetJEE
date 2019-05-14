<%-- 
    Document   : CreationPost
    Created on : 14 mai 2019, 15:49:11
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Creation d'un Poste</title>
        <link type="text/css" rel="stylesheet" href="inc/form.css" />
    </head>
    <body>
        <form method="get" action="creationPost">
            <fieldset>
                <legend>Creation d'un poste</legend>
                <p>Vous pouvez vous creer un article via ce formulaire.</p>
                <label for="title">Titre de l'article <span
                        class="requis">*</span></label>
                <input type="text" id="title" name="title" value="<c:out
                           value="${article.title}"/>"  />
                
                <br /><label for="body">Corps de votre article <span
                        class="requis">*</span></label>
                <input type="text" id="body" name="body"
                       value="<c:out value="${article.body}" />" />
              
            </fieldset>
        </form>
               <c:import url="/WEB-INF/template/footer.jsp"/>
    </body>
</html>

