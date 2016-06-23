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
                        <th>Realisateurs</th>
                        <th>Acteurs</th>
                        <th>Synopsis</th>
                        <th>Saisons</th>
                        <th>Episodes</th>                       
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${serie.titre}</td>
                        <td>${serie.genre.nom}</td>
                        <td>
                            <c:forEach items="${serie.pays}" var="pays">
                                ${pays.nom}
                                <br>
                            </c:forEach>
                        </td>  
                        <td>
                            <c:forEach items="${serie.realisateurs}" var="real">
                                ${real.nom} ${real.prenom}
                                <br>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${serie.acteurs}" var="act">
                                ${act.nom} ${act.prenom}
                                <br>
                            </c:forEach>
                        </td>
                        <td>${serie.synopsis}</td>
                        <td>
                            <c:forEach items="${serie.saisons}" var="saison">
                                <a href="detail_saison?idSaison=${saison.id}">${saison.numSaison}</a>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${saison.episodes}" var="episode">
                                ${episode.numEpisode}
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
