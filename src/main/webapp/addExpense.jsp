<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지출 등록</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>💸 지출 등록</h1>
    <form action="AddExpenseServlet" method="post" class="form-container">
        <label>항목명:</label>
        <input type="text" name="title" required><br><br>

        <label>금액:</label>
        <input type="number" name="amount" required><br><br>

        <label>카테고리:</label>
        <input type="text" name="category"><br><br>

        <label>지출 날짜:</label>
        <input type="date" name="expense_date"><br><br>

        <label>메모:</label>
        <textarea name="memo" rows="3" cols="30"></textarea><br><br>

        <input type="submit" value="등록">
    </form>

    <p><a href="index.jsp">메인으로 돌아가기</a></p>
</body>
</html>
