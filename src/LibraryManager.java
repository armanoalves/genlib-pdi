import services.LibraryService;
import services.LoanService;
import services.UserService;
import ui.MenuHandler;

public class LibraryManager {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        UserService userService = new UserService();
        LoanService loanService = new LoanService();

        MenuHandler menuHandler = new MenuHandler(libraryService, userService, loanService);
        menuHandler.exibirMenu();
    }
}
