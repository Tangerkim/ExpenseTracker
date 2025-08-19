package DTO;

import java.util.Date;

public class ExpenseDTO {
    private int id;              // 고유 번호
    private String title;        // 항목명
    private int amount;          // 금액
    private String category;     // 카테고리
    private Date expenseDate;    // 지출 날짜
    private String memo;         // 메모

    // 기본 생성자
    public ExpenseDTO() {}

    // 전체 필드를 받는 생성자
    public ExpenseDTO(int id, String title, int amount, String category, Date expenseDate, String memo) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
        this.memo = memo;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
