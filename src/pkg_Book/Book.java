package pkg_Book;

import java.io.Serializable;

public class Book implements Serializable {
    private int isbn;
    private int edition;
    private int availableQuantity;
    private String title;
    private String author;
    private String publisher;
    private String subject;

    public Book() {
    }

    public Book(int availableQuantity, String subject, String publisher, String author, String title, int edition, int isbn) {
        this.availableQuantity = availableQuantity;
        this.subject = subject;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", edition=" + edition +
                ", availableQuantity=" + availableQuantity +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
