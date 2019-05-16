<%-- 
    Document   : accueilContent
    Created on : 14 mai 2019, 15:25:16
    Author     : stagldnr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  
    <body>
        
        <%--action faut que tu regarde le web.xml et faire tous le mapping avec les servlets,etc--%>
        
         
            <%-- List<Article> list = (List<Article>)request.getAttribute("listPost");--%>
            <table>
                <c:forEach items="${requestScope.Articles}" var="Article">
                    <div >    
                        
                  <tr>
                    <td><c:out value="${pageScope.Article.title}" /></td>
                    <td><c:out value="${pageScope.Article.body.substr(0, 100)}" /></td>
                  </tr>
                    </div>
                </c:forEach>
              </table>
        
  
    </body>
</html>