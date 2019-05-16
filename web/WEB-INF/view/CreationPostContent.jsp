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
        <div>
        <%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>
        <form method="post" action="creationPost">
            <fieldset>
               
                <p>Vous pouvez vous creer un article via ce formulaire.</p>
                <label for="title">Titre de l'article <span
                        class="requis">*</span></label>
                <input type="text" id="title" name="title" value=""  />
                
                <br /><label for="body">Corps de votre article <span
                        class="requis">*</span></label>
                <textarea type="text" id="body" name="body" cols="150" rows="5"></textarea>
                       
                <br /><label for="date">date de creation de l'article <span
                        class="requis">*</span></label>
                        
                <input type="date" id="date" name="date"
                       value="<c:out value="" />" />
                
                 <input type="submit" value="Creation" class="noLabel" />
                 
            </fieldset>
        </form>
                       </div>
              
    </body>
</html>

