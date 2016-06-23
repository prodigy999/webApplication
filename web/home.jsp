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
            HOME
        </div>
        <div class="connexion">
            <c:import url="_CONNEXION.jsp"/>
        </div>
        <div class="contenu">

        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
