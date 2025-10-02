public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("═══ Library Management System Test ═══");

        Book book1 = new Book("Java Programming", "By ", "James Goling");
        Magazine dvd1 = new Magazine("OOP Concepts", "D001", "Tech Films");
        DVD mag1 = new DVD("Programming Weekly", "M001", 15);

        LibraryUser student = new Student("Alice Johnson", "S12345");
        LibraryUser teacher = new Teacher("Dr. Smith", "T001");
        LibraryUser librarian = new Librarian("Mary Brown", "L001");

        System.out.println("\n═══ Adding Items Library ═══");
        displayMediaInfo(book1);
        displayMediaInfo(dvd1);
        displayMediaInfo(mag1);

        System.out.println("\n═══ Displaying All Items ═══");
        student.borrowMedia(book1);
        teacher.borrowMedia(dvd1);
        student.borrowMedia(book1);
        System.out.println("\n═══ Testing Borrowing ═══");
        student.returnMedia(book1);
        librarian.borrowMedia(book1);

        System.out.println("\n═══ Displaying Available Items ═══");
        displayUserInfo(student);
        displayUserInfo(teacher);
        displayUserInfo(librarian);
    }

    public static void displayMediaInfo(Magazine media) {
        media.displayInfo();
    }

    public static void displayUserInfo(LibraryUser user) {
        System.out.println(user.getUserType() + " - John Smith (Computer Science): " + user.getMaxBorrowLimit() + " items");
    }
}
