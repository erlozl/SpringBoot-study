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
    <form action="/product/update" method="post" enctype="application/x-www-form-urlencoded">
            <div class="mb-3 mt-3">
                <input type="text" class="form-control"value="${product.id}" name="id">
            </div>
            <div class="mb-3">
                <input type="text" class="form-control" value="${product.name}" name="name">
            </div>
            <div class="mb-3">
                <input type="number" class="form-control" value="${product.price}" name="price">
            </div>
            <div class="mb-3">
                <input type="number" class="form-control" value="${product.qty}" name="qty">
            </div>
        <button type="submit" class="btn btn-primary">등록</button>
<%--        submit 역할 - 액션이 일어날 때 그 안에 input 데이터를 다 들고가는 거--%>
    </form>
    <form action="/product/delete" method="post">
        <input type="hidden" class="form-control" value="${product.id}" name="id">
        <button type="submit" class="btn btn-danger" >삭제</button>
    </form>
</div>

</body>
</html>

