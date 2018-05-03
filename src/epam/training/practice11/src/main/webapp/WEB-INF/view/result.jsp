<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
</head>
<body>

<c:if test="${not empty error}">
    <h3>${error}</h3>
</c:if>

<c:if test="${not empty resultObject}">
    Результат: ${resultObject.formattedResult}
</c:if>
<br>
<a href="${pageContext.request.contextPath}">Вернуться на главную</a>
</body>
</html>
