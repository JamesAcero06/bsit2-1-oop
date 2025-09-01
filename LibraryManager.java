import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<String> books;
    private Scanner scanner;

    public LibraryManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);

        books.add("Java Programming");
        books.add("Web Development");
        books.add("Database Design");
    }

    public void showBooks() {
        try {
            if (books == null) {
                throw new IllegalStateException("Book list is not initialized!");
            }
            if (books.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                System.out.println("\n--- Current Books ---");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + ". " + books.get(i));
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Display operation completed.\n");
        }
    }

    public void addBook() {
        try {
            System.out.print("Enter book title to add: ");
            String title = scanner.nextLine().trim();

            if (title.isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be empty!");
            }
            if (title.length() < 3) {
                throw new IllegalArgumentException("Book title must be at least 3 characters long!");
            }

            books.add(title);
            System.out.println("Book '" + title + "' added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Add book operation completed.\n");
        }
    }

    public void removeBook() {
        try {
            if (books.isEmpty()) {
                System.out.println("No books to remove.");
                return;
            }

            System.out.print("Enter book number to remove (1-" + books.size() + "): ");
            String input = scanner.nextLine();

            int index;
            try {
                index = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Please enter a valid number!");
            }

            if (index < 0) {
                throw new IllegalArgumentException("Book number cannot be negative!");
            }
            if (index >= books.size()) {
                throw new ArrayIndexOutOfBoundsException("Invalid book number! Please enter between 1 and " + books.size() + ".");
            }

            String removedBook = books.remove(index);
            System.out.println("Book '" + removedBook + "' removed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remove book operation completed.\n");
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        System.out.println("=== Library Management System ===");

        manager.showBooks();

        manager.addBook();
        manager.addBook();
        manager.addBook();


        manager.removeBook();
        manager.removeBook();
        manager.removeBook();

        System.out.println("Program completed successfully.");
    }
}
