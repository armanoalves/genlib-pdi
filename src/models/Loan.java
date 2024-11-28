package models;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.returnDate = loanDate.plusDays(14);
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "loan {" +
                "book=" + book +
                ", user=" + user +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
