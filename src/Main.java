public class Main {
    public static void main(String[] args) {
        System.out.println("=== Book Record System ===\n");


        Book book1 = new Book("Java Programming", "John Smith");
        Book book2 = new Book("Data Structures", "Alice Brown");
        Book book3 = new Book("Web Development", "Bob Wilson");

        System.out.println("Adding books and ratings...");

        try {
            book1.addRating(4);
            System.out.println("Rating 4 added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        book2.addMultipleRatings(5, 4, 3, 5);



        System.out.println("\nBook Results:");
        System.out.println(book1.displayBook());
        System.out.println(book2.displayBook());
        System.out.println(book3.displayBook());

        System.out.println("\nTotal books created: " + Book.getTotalBooks());

        Book highestRatedBook = book1;
        if (book2.getAverageRating() > highestRatedBook.getAverageRating()) {
            highestRatedBook = book2;
        }
        if (book3.getAverageRating() > highestRatedBook.getAverageRating()) {
            highestRatedBook = book3;
        }

        System.out.printf("Highest rated book: %s by %s (%.2f)%n",
                highestRatedBook.getTitle(),
                highestRatedBook.getAuthor(),
                highestRatedBook.getAverageRating());
    }
}
