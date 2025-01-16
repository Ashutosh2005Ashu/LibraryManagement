import java.util.Scanner;

public class LibraryController {
    private LibraryService libraryService;
    private Scanner scanner;

    public LibraryController() {
        libraryService = new LibraryService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    libraryService.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        libraryService.addBook(book);
    }

    private void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String id = scanner.nextLine();
        libraryService.removeBook(id);
    }

    private void searchBook() {
        System.out.print("Enter Book Title to search: ");
        String title = scanner.nextLine();
        Book book = libraryService.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
