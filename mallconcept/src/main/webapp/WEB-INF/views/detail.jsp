<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MALL</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <% String title = "MALL - 상세보기"; %>
    <title><%= title %></title>
<%--    상세보기는 동적으로 가기 때문에 navigation으로 할 필요가 없다--%>
<%--    동적 페이지 - 누를 때마다 데이터 때문에 바뀌는 페이지들은 할 수 없음--%>
</head>
<style>
    .btn-primary {
        background-color: black;
        color: white;
        border: 1px solid black;
    }
    .button_delete {
        padding-top : 20px;
    }
</style>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">쇼핑몰</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">상품목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/write">상품등록</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-3">
    <div class="container mt-3">
<%--        form 태그는 get과 post밖에 없음--%>
        <form action="/product/update" method="post" enctype="application/x-www-form-urlencoded">
<%--          여기에 있는 주소를 가져가서 수정하겠다--%>
<%--           주소가 아니라 바디에 들고감--%>
            <c:if test="${not empty product}">
                <div class="mb-3 mt-3">
                    <input type="text" class="form-control" value = "${product.id}" name="id">
                </div>
                <div class="mb-3 mt-3">
                    <input type="text" class="form-control" value = "${product.name}" name="name">
                </div>
                <div class="mb-3">
                    <input type="number" class="form-control" value = "${product.price}" name="price">
                </div>
                <div class="mb-3">
                    <input type="nubmer" class="form-control" value = "${product.qty}" name="qty">
                </div>
            </c:if>
            <button type="submit" class="btn btn-primary">상품 수정</button>
        </form>
        <form class="button_delete" action="/product/delete" method="post">
            <input type="hidden" class="form-control" value = "${product.id}" name="id">
            <button type="submit" class="btn btn-danger">상품 삭제</button>
        </form>
    </div>
</div>

</body>
</html>

