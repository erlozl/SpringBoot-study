<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MALL</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">

    <div class="container-fluid">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/main">쇼핑몰</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">상품 목록</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/regist">상품 등록</a>
            </li>
        </ul>
    </div>

</nav>
<div class="container mt-3">
    <table class="table table-striped">

        <thead>
        <tr>
            <th>상품 번호</th>
            <th>상품명</th>
            <th>상품 가격</th>
            <th>상품 재고</th>
            <th>날짜</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${mallJoinList}">
            <tr>
                <td><a href="/mall/${p.id}">${p.id}</a></td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.qty}</td>
                <td>${p.createAt}</td>
                <td>${p.seller.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
