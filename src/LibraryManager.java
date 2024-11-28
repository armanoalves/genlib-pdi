import services.LibraryService;
import services.LoanService;
import services.UserService;
import ui.MenuHandler;

public class LibraryManager {
    public static void main(String[] args) {
        // Criação de instâncias para cada classe de serviço
        LibraryService libraryService = new LibraryService();
        UserService userService = new UserService();
        LoanService loanService = new LoanService();

        // Passagem das instâncias criadas como parâmetro ao criar a instância do MenuGangler
        MenuHandler menuHandler = new MenuHandler(libraryService, userService, loanService);
        menuHandler.exibirMenu();
    }
}
