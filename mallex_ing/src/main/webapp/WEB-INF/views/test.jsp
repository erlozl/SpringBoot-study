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
    <form action="/test/save" method="post" enctype="application/x-www-form-urlencoded">
        <div class="mb-3 mt-3">
            <label for="num" class="form-label">번호</label>
            <input type="number" class="form-control" id="num" value="" name="id">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">상품명</label>
            <input type="text" class="form-control" id="name" value="" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">상품 가격</label>
            <input type="number" class="form-control" id="price" value="" name="price">
        </div>
        <div class="mb-3">
            <label for="qty" class="form-label">상품 재고</label>
            <input type="number" class="form-control" id="qty" value="" name="qty">
        </div>
        <div class="mb-3">
            <label for="data" class="form-label">날짜</label>
            <input type="date" class="form-control" id="data" value="" name="createAt">
        </div>
        <div class="mb-3">
            <label for="seller" class="form-label">판매자</label>
            <input type="text" class="form-control" id="seller" value="" name="seller">
        </div>
        <button type="submit" class="btn btn-primary">등록</button>
    </form>
</div>

</body>
</html>
