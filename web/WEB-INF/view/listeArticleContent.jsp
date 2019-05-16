<%-- 
    Document   : listeArticleContent
    Created on : 15 mai 2019, 14:23:40
    Author     : stagldnr
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>


<%-- List<Article> list = (List<Article>)request.getAttribute("listPost");--%>
<table>
    <c:forEach items="${requestScope.Articles}" var="Article">

        <h2> <c:out value="${pageScope.Article.title}" /></h2>
         
        <p> <c:out value=" ${fn:substring(pageScope.Article.body, 0, 1500)}" />......</p>
        
       <a href="<c:url value="/Article? id=${Article.id_Articles}"/>">en Savoir plus</a>

    </c:forEach>
</table>



