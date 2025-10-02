public class borrowed Interface {
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
