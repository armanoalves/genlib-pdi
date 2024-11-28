package ui;

import models.Book;
import models.User;
import services.LibraryService;
import services.LoanService;
import services.UserService;

import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryService libraryService;
    private final UserService userService;
    private final LoanService loanService;

    public MenuHandler(LibraryService libraryService, UserService userService, LoanService loanService) {
        this.libraryService = libraryService;
        this.userService = userService;
        this.loanService = loanService;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Gerenciador de biblioteca ---");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Registrar um usuário");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Listar todos os livros");
            System.out.println("6. Ver todos os empréstimos");
            System.out.println("0. Sair do programa");

            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer após o nextInt()

            switch (choice) {
                case 1 -> adicionarLivro();
                case 2 -> registrarUsuario();
                case 3 -> emprestarLivro();
                case 4 -> devolverLivro();
                case 5 -> listarTodosLivros();
                case 6 -> listarEmprestimos();
                case 0 -> {
                    System.out.println("Saindo do programa...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String title = scanner.nextLine(); // Aqui já captura o título corretamente

        System.out.print("Digite o nome do autor: ");
        String author = scanner.nextLine();

        libraryService.addBook(new Book(title, author));
        System.out.println("Livro adicionado com sucesso!");
    }

    private void registrarUsuario() {
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        userService.addUser(new User(name, email));
        System.out.println("Usuário registrado com sucesso!");
    }

    private void emprestarLivro() {
        System.out.print("Título do livro que deseja pegar: ");
        String title = scanner.nextLine();

        System.out.print("Digite seu nome de usuário: ");
        String userName = scanner.nextLine();

        libraryService.getAvailableBookByTitle(title).ifPresentOrElse(
                book -> {
                    userService.getUserByName(userName).ifPresentOrElse(
                            user -> {
                                loanService.loanBook(book, user);
                                System.out.println("Livro emprestado com sucesso!");
                            },
                            () -> System.out.println("Usuário não encontrado.")
                    );
                },
                () -> System.out.println("Livro não encontrado ou indisponível.")
        );
    }

    private void devolverLivro() {
        System.out.print("Digite o título do livro para devolução: ");
        String title = scanner.nextLine();

        libraryService.getAvailableBookByTitle(title).ifPresentOrElse(
                book -> {
                    loanService.returnBook(book);
                    System.out.println("Livro devolvido com sucesso!");
                },
                () -> System.out.println("Livro não encontrado.")
        );
    }

    private void listarTodosLivros() {
        System.out.println("\nLista de Livros:");
        libraryService.getAllBooks().forEach(System.out::println);
    }

    private void listarEmprestimos() {
        System.out.println("\nLista de Empréstimos:");
        loanService.getAllLoans().forEach(System.out::println);
    }
}