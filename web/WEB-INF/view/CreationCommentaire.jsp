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
        <div>
        <%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>
        <form method="commentaire" action="creationCommentaire">
            <fieldset>
               
                <p>Vous pouvez créer un commentaire ici.</p>
                <label for="title">Commentaire<span
                        class="requis">*</span></label>
                <input type="text" id="id_commentaire" name="id_commentaire" value=""  />
                
                <br /><label for="contenu">Corps de votre commentaire <span
                        class="requis">*</span></label>
                <textarea type="text" id="contenu" name="contenu" cols="150" rows="5"></textarea>
                       
                <br /><label for="date">date de creation du commentaire <span
                        class="requis">*</span></label>
                        
                <input type="date" id="date" name="date"
                       value="<c:out value="" />" />
                
                 <input type="submit" value="Creation" class="noLabel" />
                 
            </fieldset>
        </form>
                       </div>
               <c:import url="/WEB-INF/template/footer.jsp"/>
    </body>
</html>
