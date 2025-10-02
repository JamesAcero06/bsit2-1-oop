public class Student extends Abstract User {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    @Override
    public String getUserType() {
        return "Student";
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public void borrowMedia(Media media) {
        if (media.isAvailable()) {
            media.borrowItem();
            System.out.println(name + " (" + getUserType() + ") borrowed: " + media.getTitle());
        } else {
            System.out.println("Sorry, " + media.getTitle() + " is not available");
        }
    }

    @Override
    public void returnMedia(Media media) {
        media.returnItem();
        System.out.println(name + " (" + getUserType() + ") returned: " + media.getTitle());
    }
}

this.title = title;
this.author = author;
this.isCheckedOut = false;
        this.borrowerName = null;
        }

public String getItemInfo() {
    return String.format("%s: %s by %s (%s)", getItemType(), title, author, isCheckedOut ? "Checked out by " + borrowerName : "Available");
}

public void checkOut(String borrowerName) {
    if (!isCheckedOut) {
        this.isCheckedOut = true;
        this.borrowerName = borrowerName;
    }
}

public void checkIn() {
    this.isCheckedOut = false;
    this.borrowerName = null;
}

public String getItemId() { return itemId; }
public String getTitle() { return title; }
public String getAuthor() { return author; }

public abstract String getItemType();
public abstract double calculateLateFee(int daysLate);
}
