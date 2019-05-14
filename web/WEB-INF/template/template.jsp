<%-- 
    Document   : template
    Created on : 13 mai 2019, 14:49:59
    Author     : stagldnr
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${param.title}"/></title>
       
    </head>
    <body>
        <header>
            <jsp:include page="/WEB-INF/template/adminheader.jsp" />
        </header>
        <section id="content">
            <jsp:include page="/WEB-INF/view/${param.content}.jsp" />
        </section>
        <footer>
            <jsp:include page="/WEB-INF/template/footer.jsp" />
        </footer>
    </body>
</html>