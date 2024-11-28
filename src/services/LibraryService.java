package services;

import models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Classe de serviço para objetos Book
public class LibraryService {
    // Lista de livros que será usada durante o gerenciamento
    private final List<Book> books = new ArrayList<>();

    // Método de adicionar livros a lista
    public void addBook(Book book) {
        books.add(book);
    }

    // Método de retornar todos os livros da lista
    public List<Book> getAllBooks() {
        return books;
    }

    // Método que pode retornar um livro pelo titulo
    public Optional<Book> getAvailableBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable())
                .findFirst();
    }
}
