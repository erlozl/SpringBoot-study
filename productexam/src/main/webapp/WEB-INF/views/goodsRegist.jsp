<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="/">쇼핑몰</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">상품 목록</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/goods">상품 등록</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-3">
    <form action="/goodsList " method="post" enctype="application/x-www-form-urlencoded">
        <div class="mb-3">
            <label for="goods" class="form-label">품명</label>
            <input type="text" id="goods" class="form-control" value="바나나" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">가격</label>
            <input type="number" id="price" class="form-control" value="2000" name="price">
        </div>
        <div class="mb-3">
            <label for="qty" class="form-label">재고</label>
            <input type="number" id="qty" class="form-control" value="50" name="qty">
        </div>
        <button type="submit" class="btn btn-primary">등록하다</button>
    </form>
</div>

</body>
</html>

