
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h2>${localeCars}</h2>

<h3>${message}</h3>

Language : <a href="?locale=en">English</a>|<a href="?locale=ru">Russian</a>
<table >

    <thead class="thead-dark">
    <tr>
        <th scope="col">Car number</th>
        <th scope="col">Car series</th>
        <th scope="col">Car color</th>

    </tr>
    </thead>

    <tbody class="table-striped table-hover">

    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.getNumber()}</td>
            <td>${car.getSeries()}</td>
            <td>${car.getColor()}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>