<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="Lister_Films">Films</a>
<a href="Lister_Series">Series</a>
<c:choose>
    <c:when test="${cookie.login==null}">
        <a href="login">Connexion</a>
    </c:when>
    <c:otherwise>
        <a href="home">Deconnexion</a>
        <c:if test="${cookie.utilType.getValue()=='ADMIN'}">
            <a href="ajout_film">Ajout Film</a>
            <a href="ajout_serie">Ajout Serie</a>
        </c:if>
    </c:otherwise>
</c:choose>
<label>Style :</label>            
<select name="style">
    <label>Pays :</label>
     <option value="style1">Blanc</option>
     <option value="style2">Bleu</option>
</select>
