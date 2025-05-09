package pkg_Book;

import pkg_Person.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class BookManager {

    ObjectOutputStream  objectOutputStream = null;
    ObjectInputStream objectInputStream = null;


    File bookFile = new File("books.dat");
    ArrayList<Book> bookList = null;

    public BookManager() {
        bookList = new ArrayList<Book>();
        if (bookFile.exists()){
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(bookFile));
                try {
                    bookList = (ArrayList<Book>) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /// Add Books
    public void addBooks(Book book){
        bookList.add(book);
    }

    ///  View All Books
    public void viewAllBooks(){
        for (Book e : bookList){
            System.out.println(e);
        }
    }

    ///  Search book by ISBN code
    public Book searchBookByISBN(int isbn ){
        for (Book book : bookList){
            if (book.getIsbn() == isbn){
                return book;
            }
        }
        return null;
    }

    public void searchByBookName(String subjectName){
        for (Book book :bookList){
            if (book.getSubject().equals(subjectName)){
                System.out.println(book);
            }
        }
    }

    ///  delete book by ISBN code
    public boolean deleteBookByISBN (int isbn){
        ListIterator<Book> bookListIterator = bookList.listIterator();
        while (bookListIterator.hasNext()){
            Book book = bookListIterator.next();
            if (book.getIsbn() == isbn){
                bookList.remove(book);
                return true;
            }
        }
        return false;

    }
    ///  Update book by ISBN code
    public boolean updateBookByISBN (int isbn, int edition, int availableQuantity, String title, String author, String publisher, String subject){
        ListIterator<Book> bookListIterator = bookList.listIterator();
        while (bookListIterator.hasNext()){
            Book book = bookListIterator.next();
            if (book.getIsbn() == isbn){
                book.setAuthor(author);
                book.setEdition(edition);
                book.setAvailableQuantity(availableQuantity);
                book.setTitle(title);
                book.setPublisher(publisher);
                book.setSubject(subject);
                return true;
            }
        }
        return false;

    }

    public void writeToFile() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(bookFile));
            objectOutputStream.writeObject(bookList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Book get(int updateWithISBN) {
        for (Book book : bookList){
            int rln = book.getIsbn();
            if (rln == updateWithISBN){
                return book;
            }
        }
        return null;
    }



}
