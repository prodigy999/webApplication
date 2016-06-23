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
            <h1>Ajouter Serie</h1>
            <form method="post">
                <label for="titre">Titre :</label>
                <input name="titre" type="text" width="150">
                <br />
                <br />
                <label for="synopsis">Synopsis :</label>
                <input name="synopsis" type="text" width="400">
                <br />
                <br />
                <label>Genre :</label>
                <select name="genre_id">
                    <c:forEach items= "${genres}" var="genre">
                        <option value="${genre.id}">${genre.nom}</option>
                    </c:forEach>
                </select>
                <br />
                <br />
                <label>Pays :</label>
                <select name="pays_id">
                    <c:forEach items= "${pays}" var="pays">
                        <option value="${pays.id}">${pays.nom}</option>
                    </c:forEach>
                </select>
                <br />
                <br />
                <input type="submit">
                </div>
                <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>