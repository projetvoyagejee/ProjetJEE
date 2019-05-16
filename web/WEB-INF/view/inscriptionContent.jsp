<%-- 
    Document   : inscriptionContent
    Created on : 16 mai 2019, 10:16:32
    Author     : stagldnr
--%>

<form method="post" action="inscription">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>
        <label for="email">Adresse email <span class="mandatory">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
        <span class="error">${form.errors.email}</span>

        <br />
        <label for="password">Mot de passe <span class="mandatory">*</span></label>
        <input type="password" id="password" name="password" value="<c:out value="${user.password}"/>" size="20" maxlength="20" />
        <span class="error">${form.errors.password}</span>
        <br />
        <label for="confirm">Confirmation <span class="mandatory">*</span></label>
        <input type="password" id="confirm" name="confirm" value="" size="20" maxlength="20" />
        <span class="error">${form.errors.confirm}</span>
        <br />
        <label for="username">Nom d'utilisateur</label>
        <input type="text" id="username" name="username" value="<c:out value="${user.name}"/>" size="20" maxlength="20" />
        <span class="error">${form.errors.username}</span>
        <br />
        <input type="submit" value="Inscription" class="noLabel" />
        <p>Les champs marqués d'un <span class="mandatory">*</span> sont obligatoires.</p>
        <p class="${(empty form.errors) ? 'success' : 'error'}">${form.result}</p>
    </fieldset>
</form>
<c:import url="/WEB-INF/template/footer.jsp"/>