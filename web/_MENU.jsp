<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="Lister_Films">Films</a>
<a href="Lister_Series">Series</a>
<c:choose>
    <c:when test="${UtilConnecte.login==null}">
        <a href="login">Connexion</a>
    </c:when>
    <c:otherwise>
        <a href="home">Deconnexion</a>
        <c:if test="${UtilConnecte.typeUtil=='ADMIN'}">
            <a href="ajout_film">Ajout Film</a>
            <a href="ajout_serie">Ajout Serie</a>
            <a href="stylesheet?style_cookie=style1">Blanc</a>
            <a href="stylesheet?style_cookie=style2">Bleu</a>
        </c:if>
    </c:otherwise>
</c:choose>

