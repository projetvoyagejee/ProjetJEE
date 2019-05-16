<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${param.title}"/></title>
        <link rel="stylesheet" href="inc/css/utilisateur.css">
        <link rel="stylesheet" href="inc/css/templateCSS.css">
        <link rel="stylesheet" href="inc/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <jsp:include page="/WEB-INF/template/headerGeneral.jsp" />
        </header>

        <section id="content">
            <jsp:include page="/WEB-INF/view/${param.content}.jsp" />
        </section>

        <footer>
            <jsp:include page="/WEB-INF/template/footer.jsp" />
        </footer>
    </body>
</html>