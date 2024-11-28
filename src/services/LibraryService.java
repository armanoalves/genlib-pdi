package services;

import models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getAvailableBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable())
                .findFirst();
    }
}
