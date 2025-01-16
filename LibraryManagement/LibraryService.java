import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
        System.out.println("Book removed successfully.");
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }
}
