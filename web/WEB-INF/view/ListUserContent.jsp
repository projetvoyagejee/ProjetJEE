<%-- 
    Document   : ListUserContent
    Created on : 16 mai 2019, 11:06:13
    Author     : stagldnr
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

        
        <table class = "tabuser">
                <c:forEach items="${requestScope.User}" var="utilisateur">
                    <tr class="tru">
                        <td  class="tdu"> <c:out value="${pageScope.utilisateur.email}" /></td>
                        
                        <td class="tdu"><c:out value="${pageScope.utilisateur.name}" /></td>
                    
                        <td class="tdu"><c:out value="${pageScope.utilisateur.etat}" /></td>
                  
                        <td class="tdu"><c:out value="${pageScope.utilisateur.admin}" /></td>
<!--                        rajouter un cchoose par rapport a l'etat de l'user-->
                        <td class="tdu"> <a href="desinscrire">Bloquer l'utilisateur</a></td>
                        
                        <td class="tdu"> <a href="supprimer"style="color:#f00">Supprimer l'utilisateur</a></td>
                    </tr>
                      
                   
                    
                </c:forEach>
              </table>
        
        
