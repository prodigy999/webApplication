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
                        <th>Realisateurs</th>
                        <th>Acteurs</th>
                        <th>Synopsis</th>
                        <th>Liens</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${film.titre}</td>
                        <td>${film.annee}</td>
                        <td>${film.genre.nom}</td>
                        <td>
                            <c:forEach items="${film.pays}" var="pays">
                                ${pays.nom}
                                <br>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${film.realisateurs}" var="real">
                                ${real.nom} ${real.prenom}
                                <br>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${film.acteurs}" var="act">
                                ${act.nom} ${act.prenom}
                                <br>
                            </c:forEach>
                        </td>
                        <td width="500">${film.synopsis}</td>
                        <td>
                            <c:forEach items="${film.liens}" var="lien">
                                <a href="${lien.url}">${lien.url}</a>
                                <br>
                            </c:forEach>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
