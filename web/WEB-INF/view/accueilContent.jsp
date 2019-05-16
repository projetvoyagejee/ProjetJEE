<%-- 
    Document   : accueilContent
    Created on : 14 mai 2019, 15:25:16
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<html>
  
    <body>
        
        <%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>
        
         
            <%-- List<Article> list = (List<Article>)request.getAttribute("listPost");--%>
            <table>
               <c:forEach items="${requestScope.Articles}" var="Article">
                    <div>    
                        
                  
                    <h2><c:out value="${pageScope.Article.title}" /></h2>
                    <br>
                    <p> <c:out value="${fn:substring(pageScope.Article.body,0,1500)}" />....</p>
                    
                    
                    <br>
                    </div>
                </c:forEach>
              </table>
        
  
    </body>
</html>
