<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${cookie.style_prefere=='blanc'}">
        <link href="CSS/style1.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:when test="${cookie.style_prefere=='bleu'}">
        <link href="CSS/style2.css" rel="stylesheet" type="text/css"/>
    </c:when>
</c:choose>

