package pkg_Transactions;


import pkg_Book.Book;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookTransactionManager {

    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;

    File booksTransactionFile = null;
    ArrayList<BooksTransaction> booksTransactionList = null;

    public BookTransactionManager(){
        booksTransactionFile = new File("BookTransaction.dat");
        booksTransactionList = new ArrayList<BooksTransaction>();

        if (booksTransactionFile.exists()){
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(booksTransactionFile));
                try {
                    booksTransactionList = (ArrayList<BooksTransaction>)objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    ///   Book Issue
    public boolean isBookIssued(int isbn, int rollNumber){
        int totalIssuedBooks = 0;
        for (BooksTransaction booksTransaction : booksTransactionList){
            if (totalIssuedBooks >= 3){
                return false;
            }else {
                if ((booksTransaction.getRollNumber() == rollNumber) && (booksTransaction.getReturnDate() == null)){
                    totalIssuedBooks += 1;
                }
            }
        }
        String bookIssueDate = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
        BooksTransaction booksTransaction = new BooksTransaction(isbn, rollNumber, bookIssueDate, null);
        booksTransactionList.add(booksTransaction);
        return true;
    }

    ///  Return Book
    public boolean returnBook(int rollNumber, int isbn){

        for (BooksTransaction booksTransaction : booksTransactionList){
            if ((booksTransaction.getRollNumber() == rollNumber) && (booksTransaction.getIsbn() == isbn )&& (booksTransaction.getReturnDate() == null)){
                String returnDate = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
                booksTransaction.setReturnDate(returnDate);
                return true;
            }
        }
        return false;

    }

    ///  Show all transaction Books
    public void showAllTransactions(){
        for (BooksTransaction booksTransaction : booksTransactionList){
            System.out.println(booksTransaction);
        }
    }

    public void writeToFile() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(booksTransactionFile));
            objectOutputStream.writeObject(booksTransactionList); // Save the actual list
            objectOutputStream.close(); // Always close the stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
