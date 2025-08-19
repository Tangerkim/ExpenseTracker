package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ExpenseDAO;
import DTO.ExpenseDTO;

@WebServlet("/ListExpenseServlet")
public class ListExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ExpenseDAO dao = new ExpenseDAO();
        List<ExpenseDTO> expenses = dao.getAllExpenses();

        request.setAttribute("expenses", expenses);
        request.getRequestDispatcher("expenseList.jsp").forward(request, response);
    }
}