<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <table>
                <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Genre</th>
                        <th>Pays</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${series}" var="serie">
                        <tr>
                            <td><a href="detail_serie?idSerie=${serie.id}">${serie.titre}</a></td>
                            <td>${serie.genre.nom}</td>
                            <td>
                                <c:forEach items="${serie.pays}" var="pays">
                                    ${pays.nom}
                                </c:forEach></td>
                                <c:if test="${cookie.utilType.getValue()=='ADMIN'}">
                                <td><a href="suppr_serie?idSerie=${serie.id}">Supprimer</a></td>
                                </c:if>
                                <br>
                     </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
