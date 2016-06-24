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
                        <th>Année</th>
                        <th>Genre</th>
                        <th>Pays</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${films}" var="film">
                        <tr>
                            <td><a href="detail_film?idFilm=${film.id}">${film.titre}</a></td>
                            <td>${film.annee}</td>
                            <td>${film.genre.nom}</td>
                            <td>
                                <c:forEach items="${film.pays}" var="pays">
                                    ${pays.nom}
                                    <br>
                                </c:forEach>
                            </td>
                            <c:if test="${UtilConnecte.typeUtil=='ADMIN'}">
                                <td><a href="suppr_film?idFilm=${film.id}">Supprimer</a></td>
                            </c:if>
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
