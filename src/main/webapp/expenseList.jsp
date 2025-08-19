<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:when test="${empty expenses}">
			<p>등록된 지출 내역이 없습니다.</p>
		</c:when>
		<c:otherwise>
			<table class="expense-table">
				<thead>
					<tr>
						<th>항목명</th>
						<th>금액</th>
						<th>날짜</th>
						<th>카테고리</th>
						<th>메모</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${expenses}">
						<tr>
							<td>${item.title}</td>
							<td>${item.amount}</td>
							<td>${item.expenseDate}</td>
							<td>${item.category}</td>
							<td>${item.memo}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<p>
		<a href="index.jsp">메인으로 돌아가기</a>
	</p>
</body>
</html>
