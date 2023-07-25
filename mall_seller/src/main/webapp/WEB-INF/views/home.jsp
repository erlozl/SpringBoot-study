<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">쇼핑몰</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">상품 목록</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/write">상품 등록</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-3">
    <table class="table">
        <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>상품재고</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${productList}">
<%--            request객체에 저장된 값을 꺼내올 수 있음 문법 ${}--%>
            <tr>
                <td>${p.id}</td>
                <td><a href="/product/${p.id}"> ${p.name}</a></td>
                <td>${p.price}</td>
                <td>${p.qty}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>


