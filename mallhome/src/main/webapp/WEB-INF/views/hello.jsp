<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSP 페이지에서 JSTL(Core JSP Standard Tag Library)을 사용하기 위해 태그 라이브러리를 선언하는 부분--%>
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
<style>
    h1 {
        background-color: #333;
        color: #fff;
        text-align:center;
        padding: 20px;
    }
    h4{
        padding: 10px 0;
        border-bottom: 1px solid #eee;
    }
    div {
        margin-bottom: 20px;
    }
</style>
<body>
<h1>렌더링</h1>
<div class="container mt-3">

    <h4>(JSP)에서 사용되는 스크립트릿과 표현식, 하나씩 표현</h4>
    <div>
        <%
            String valueName = (String)request.getAttribute("gildonggildong");
            System.out.println("name : "+valueName);
        %>
        <%=valueName%>
    </div>


    <h4>JSTL라이브러리, 하나씩 표현</h4>
    <div>
        ${banana}
        ${apple}
    </div>

    <h4>(JSP)에서 사용되는 스크립트릿과 표현식, List로 표현</h4>
    <div>
        <%
            List<String> list = (ArrayList<String>)request.getAttribute("fruitlist");
            for(int i=0; i<list.size(); i++){
        %>
            <%=list.get(i)%>
        <%
            }
        %>
    </div>


    <h4> JSTL라이브러리, List로 표현</h4>
    <div>
        <c:forEach var="fruit" items="${fruitlist}">
            ${fruit}
        </c:forEach>
    </div>

</div>

</body>
</html>

