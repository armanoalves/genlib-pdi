package services;

import models.Book;
import models.Loan;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanService {
    private final List<Loan> loans = new ArrayList<>();

    public void loanBook(Book book, User user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            Loan loan = new Loan(book, user);
            loans.add(loan);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não está disponível");
        }
    }

    public void returnBook(Book book) {
        Optional<Loan> loan = loans.stream()
                .filter(l -> l.getBook().equals(book))
                .findFirst();

        if (loan.isPresent()) {
            book.setAvailable(true);
            loans.remove(loan.get());

            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro para ser devolvido não foi encontrado");
        }
    }

    public List<Loan> getAllLoans() {
        return loans;
    }
}
