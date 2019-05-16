<%-- 
    Document   : CreationPost
    Created on : 14 mai 2019, 15:49:11
    Author     : stagldnr
--%>

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
            <textarea type="text" id="body" name="body" cols="95" rows="5"></textarea>

            <br /><label for="date">date de creation de l'article <span
                    class="requis">*</span></label>

            <input type="date" id="date" name="date"
                   value="<c:out value="" />" />

            <input type="submit" value="Creation" class="noLabel" />

        </fieldset>
    </form>
</div>
<c:import url="/WEB-INF/template/footer.jsp"/>


