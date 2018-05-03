<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Трегонометрические функции</title>
</head>
<body>
<h2 align="center"> Посчитать тригонометрическую функцию </h2>


<form action="${pageContext.request.contextPath}/calc" method="get">
    Функция:
    <select name="function">
        <option value="sin">Синус</option>
        <option value="cos">Косинус</option>
        <option value="tng">Тангенс</option>
        <option value="ctn">Котангенс</option>
    </select>
    <br>

    Исходное значения: <input type="number" name="value" required>
    Точность: <select name="precision">
    <c:forEach var="i" begin="0" end="10">
        <option value="${i}">${i}</option>
    </c:forEach>
    </select>
    <br>

    Еденицы:
    <input type="radio" name="unit" value="degrees" required> Градусы
    <input type="radio" name="unit" value="radians" required> Радианы
    <br>

    <input type="submit" value="Вычислить">
</form>
</body>
</html>
