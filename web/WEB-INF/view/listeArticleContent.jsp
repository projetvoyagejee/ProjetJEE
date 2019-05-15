<%-- 
    Document   : listeArticleContent
    Created on : 15 mai 2019, 14:23:40
    Author     : stagldnr
--%>

<%@page import="java.util.List"%>
<%@page import="beans.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste de Post</title>
        <link type="text/css" rel="stylesheet" href="inc/form.css" />
    </head>
    <body>
        <div>
        <%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>
        
         
            <% List<Article> list = (List<Article>)request.getAttribute("listPost");%>
            <%for(Article a : list)
            {
                out.print("<p>"+a.getTitle()+"</p>");
                out.println("<br>");
                out.print("<p>"+a.getBody()+"</p>");
                
            }%>
        
        </div>
               <c:import url="/WEB-INF/template/footer.jsp"/>
    </body>
</html>

