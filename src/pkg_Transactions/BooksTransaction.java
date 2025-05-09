package pkg_Transactions;

import java.io.Serializable;

public class BooksTransaction implements Serializable {

    private int isbn;
    private int rollNumber;

    private String issueDate;
    private String returnDate;

    public BooksTransaction() {
    }

    public BooksTransaction(int isbn, int rollNumber, String issueDate, String returnDate) {
        this.isbn = isbn;
        this.rollNumber = rollNumber;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BooksTransaction{" +
                "isbn=" + isbn +
                ", rollNumber=" + rollNumber +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
