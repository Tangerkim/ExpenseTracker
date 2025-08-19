package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.ExpenseDAO;
import DTO.ExpenseDTO;

@WebServlet("/AddExpenseServlet")
public class AddExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
        	String title = request.getParameter("title");   
        	int amount = Integer.parseInt(request.getParameter("amount"));
        	String category = request.getParameter("category");
        	String dateStr = request.getParameter("expense_date");
        	String memo = request.getParameter("memo"); // 폼에 없으니 기본값 처리


            Date expenseDate = null;
            if (dateStr != null && !dateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                expenseDate = sdf.parse(dateStr);
            } else {
                expenseDate = new Date(); // 기본값: 오늘 날짜
            }

            ExpenseDTO dto = new ExpenseDTO();
            dto.setTitle(title);
            dto.setAmount(amount);
            dto.setCategory(category);
            dto.setMemo(memo);
            dto.setExpenseDate(expenseDate);

            ExpenseDAO dao = new ExpenseDAO();
            dao.insertExpense(dto);

            // 등록 후 메인 페이지로 리다이렉트
            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("지출 등록 중 오류 발생");
        }
    }
}