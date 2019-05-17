<%-- 
    Document   : ArticleContent
    Created on : 16 mai 2019, 15:38:21
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    
    
    <h2><c:out value="${requestScope.Article.title}" /></h2>
    <<c:out value=" ${requestScope.Article.body}"/>></div>
    <br>
        <a href="like">J'aime</a>
       <a href="likenot">J'aime pas</a>



</article>
