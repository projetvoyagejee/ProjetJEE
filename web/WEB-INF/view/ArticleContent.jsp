<%-- 
    Document   : ArticleContent
    Created on : 16 mai 2019, 15:38:21
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article items="${requestScope.Article.id_Article}" var="Article">
    
    
    <h2><c:out value="${pageScope.Article.title}" /></h2>
    <<c:out value=" ${pageScope.Article.body}"/>></div>





</article>
