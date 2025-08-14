<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지출 내역 조회</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>📄 지출 내역</h1>

    <c:choose>
        <c:when test="${empty list}">
            <p>등록된 지출 내역이 없습니다.</p>
        </c:when>
        <c:otherwise>
            <table class="expense-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>항목명</th>
                        <th>금액</th>
                        <th>날짜</th>
                        <th>카테고리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.item}</td>
                            <td>${item.amount}</td>
                            <td>${item.spentDate}</td>
                            <td>${item.category}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

    <p><a href="index.jsp">메인으로 돌아가기</a></p>
</body>
</html>
