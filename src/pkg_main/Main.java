package pkg_main;

import pkg_Book.Book;
import pkg_Book.BookManager;
import pkg_Person.Student;
import pkg_Person.StudentManager;
import pkg_Transactions.BookTransactionManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Library Management System");

        int choice ;
        Scanner sc = new Scanner(System.in);

        BookManager  bookManager = new BookManager();
        StudentManager studentManager = new StudentManager();
        BookTransactionManager bookTransactionManager = new BookTransactionManager();

        do {
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian \nEnter 3 if want to Exit");

            choice = sc.nextInt();
            // ---------------  if user Student   ---------------     START      ---------------
            if (choice == 1 ){ // if user Student
                System.out.println("Enter your Roll Number ");
                int rln = sc.nextInt();
                try {
                    Student student = studentManager.getStudentByRollNumber(rln);
                    if (student == null) throw new StudentNotFoundException();
                    int studnetCohice ;
                    do {
                        System.out.println("Enter 1 to view all books ! \nEnter 2 to find book with ISBN ! \nEnter 3 to find Book By Subject !\nEnter 4 to Issues a new book!\nEnter 5 to Return book\nEnter 99 to Exit");
                        studnetCohice = sc.nextInt();
                        switch (studnetCohice){
                            case 1:
                                System.out.println("All Books record are : ");
                                bookManager.viewAllBooks();
                                break;
                            case 2:
                                int codeISBN;
                                System.out.println("Enter ISBN to search Book");
                                codeISBN = sc.nextInt();
                                Book book = bookManager.searchBookByISBN(codeISBN);
                                if (book == null) System.out.println("No book found with this ISBN code insure to this ISBN is right : " + codeISBN);
                                else System.out.println(book);
                                break;
                            case 3:
                                System.out.println("Enter book subject to find `Book`");
                                sc.nextInt();
                                String searchSubject = sc.nextLine();
                                bookManager.searchByBookName(searchSubject);

                                break;
                            case 4:
                                System.out.println("Enter ISBN to ISSUE book ");
                                int issueISBN = sc.nextInt();
                                book = bookManager.searchBookByISBN(issueISBN);
                                try {
                                    if (book == null){
                                        throw new BookNotFoundException();
                                    }
                                    if (book.getAvailableQuantity() > 0){
                                        if (bookTransactionManager.isBookIssued(rln ,issueISBN)){
                                            book.setAvailableQuantity(book.getAvailableQuantity()-1);
                                            System.out.println("Book Has been Issue ");
                                        }
                                    }
                                }catch (BookNotFoundException e){
                                    System.out.println(e);
                                }
                                break;
                            case 5:
                                System.out.println("Enter ISBN to return book");
                                int returnISBN = sc.nextInt();
                                book = bookManager.searchBookByISBN(returnISBN);
                                if (book == null){
                                    if (bookTransactionManager .returnBook(rln, returnISBN)){
                                        book.setAvailableQuantity(book.getAvailableQuantity()+1);
                                        System.out.println("thanks for retuning");
                                    }else {
                                        System.out.println("Could not return the book!");

                                    }
                                }else {
                                    System.out.println("ISBN not found " + returnISBN);
                                }
                                break;

                            default:
                                System.out.println("Enter valid Input");

                        }

                    } while (studnetCohice != 99);


                } catch (StudentNotFoundException snfe) {
                    System.out.println(snfe);
                }
            } else if (choice  == 2) {   //  STUDENT END OR  Librarian START

                int  isLibrarianChoice ;

                do {

                    System.out.println("Enter 11 to View all Students\nEnter 12 to get Student by Roll Number\nEnter 13 to Register a Student\nEnter 14 update Student\nEnter 15 to Delete a Student");
                    System.out.println("------------------------------------------   BOOK MGMT   ---------------------------------------------------------------------------------------------------");
                    System.out.println("Enter 21 to View all Books\nEnter 22 to get Book by ISBN\nEnter 23 to Add new Book\nEnter 24 update a Book\nEnter 25 to Delete a book");
                    System.out.println("Enter 31 to view All Transactions\nEnter 99 to Exit");
                    isLibrarianChoice = sc.nextInt(); // getting roll number
                    switch (isLibrarianChoice){
                        case 11: // GET ALL STUDENTS
                            System.out.println("There are current record of Students !");
                            studentManager.getAllStudents();
                            break;
                        case 12: // SEARCH STUDENT BASED ON ROLL NUMBER
                            System.out.println("Please enter the roll number to retrieve student information.");
                            int getRollNumber = sc.nextInt();
                            System.out.println("This student is given to you as per your roll number.");
                            Student student = studentManager.getStudentByRollNumber(getRollNumber);
                            if (student == null){
                                System.out.println("No record found for this roll number: " + getRollNumber);
                            }else {
                                System.out.println(student);
                            }
                            break;
                        case 13: // ADD A NEW STUDENT
                            System.out.println("Enter student details: ");
                            String name;
                            String email;
                            String phone;
                            String address;
                            String dateOfBirth;
                            int rollNumber;
                            int standard;
                            String division;

                            sc.nextLine(); // Consume newline
                            System.out.print("Name: ");
                            name = sc.nextLine();

                            System.out.print("Email: ");
                            email = sc.nextLine();

                            System.out.print("Phone: ");
                            phone = sc.nextLine();

                            System.out.print("Address: ");
                            address = sc.nextLine();

                            System.out.print("Date of Birth (dd-MM-yyyy): ");
                            dateOfBirth = sc.nextLine();

                            System.out.print("Roll Number: ");
                            rollNumber = sc.nextInt();

                            System.out.print("Standard: ");
                            standard = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Division: ");
                            division = sc.nextLine();
                            // Adding a new student
                            Student addAStudent = new Student(name, email, phone, address,dateOfBirth, rollNumber, standard, division);
                            studentManager.addStudent(addAStudent);
                            System.out.println("Student is Added");
                            break;
                        case 14: // Update a student
                            System.out.println("Enter the Roll number to update the student's details.");
                            int rollNo;
                            rollNo = sc.nextInt();
                            student = studentManager.get(rollNo);

                            try{
                                if (student == null) throw new StudentNotFoundException();
                                sc.nextLine(); // Consume newline
                                System.out.print("Name: ");
                                name = sc.nextLine();

                                System.out.print("Email: ");
                                email = sc.nextLine();

                                System.out.print("Phone: ");
                                phone = sc.nextLine();

                                System.out.print("Address: ");
                                address = sc.nextLine();

                                System.out.print("Date of Birth (dd-MM-yyyy): ");
                                dateOfBirth = sc.nextLine();

                                System.out.print("Standard: ");
                                standard = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Division: ");
                                division = sc.nextLine();
                                studentManager.updateStudentByRollNo(rollNo,name, email, phone, address, dateOfBirth, standard, division);
                                System.out.println("Student Record is updated !");
                            }catch (StudentNotFoundException e){
                                System.out.println(e);
                            }
                            break;
                        case 15: // To Delete a student
                            System.out.println("Enter the roll number to delete the student's record.");
                            int rollDelete;
                            rollDelete = sc.nextInt();
                            if (studentManager.deleteStudentById(rollDelete)){
                                System.out.println("Student Record Removed Successfully!!... ");
                            }else {
                                System.out.println("No Record Removed with this roll number please insure correct roll number : " + rollDelete);
                            }
                            break;
                        case 21 :
                            System.out.println(" ---------              All Book record found       -------------");
                            bookManager.viewAllBooks();
                            break;
                        case 22: // get book by ISBN
                            int isbnCode;
                            System.out.println("Enter ISBN to search Book");
                            isbnCode = sc.nextInt();
                            Book book = bookManager.searchBookByISBN(isbnCode);
                            if (book == null) System.out.println("No book found with this ISBN code insure to this ISBN is right : " + isbnCode);
                            else System.out.println(book);
                            break;
                        case 23 :
                            System.out.println("Please Enter Book Details");
                            int isbn;
                            int edition;
                            int availableQuantity;
                            String title;
                            String author;
                            String publisher;
                            String subject;

                            System.out.print("Enter ISBN: ");
                            isbn = sc.nextInt();

                            System.out.print("Enter Edition: ");
                            edition = sc.nextInt();

                            System.out.print("Enter Available Quantity: ");
                            availableQuantity = sc.nextInt();
                            sc.nextLine(); // Consume the leftover newline

                            System.out.print("Enter Title: ");
                            title = sc.nextLine();

                            System.out.print("Enter Author: ");
                            author = sc.nextLine();

                            System.out.print("Enter Publisher: ");
                            publisher = sc.nextLine();

                            System.out.print("Enter Subject: ");
                            subject = sc.nextLine();

                            book = new Book(availableQuantity, subject, publisher, author,  title,  edition, isbn);
                            bookManager.addBooks(book);
                            System.out.println("Book Add Successfully !");

                            break;
                        case 24 :
                            System.out.println("Please enter ISBN to update record");
                            int updateWithISBN ;
                            System.out.println("Enter ISBN to update record");
                            updateWithISBN = sc.nextInt();
                            try {
                                book = bookManager.get(updateWithISBN);
                                if (book == null){
                                    throw  new BookNotFoundException();
                                }

                                System.out.print("Enter Edition: ");
                                edition = sc.nextInt();

                                System.out.print("Enter Available Quantity: ");
                                availableQuantity = sc.nextInt();
                                sc.nextLine(); // Consume the leftover newline

                                System.out.print("Enter Title: ");
                                title = sc.nextLine();

                                System.out.print("Enter Author: ");
                                author = sc.nextLine();

                                System.out.print("Enter Publisher: ");
                                publisher = sc.nextLine();

                                System.out.print("Enter Subject: ");
                                subject = sc.nextLine();
                                bookManager.updateBookByISBN(updateWithISBN, edition, availableQuantity, title, author, publisher, subject);
                            }catch (BookNotFoundException e){
                                System.out.println(e);
                            }
                            break;
                        case 25:
                            System.out.println("Enter ISBN to delete book");
                            int deleteISBN;
                            deleteISBN = sc.nextInt();
                            try{
                                book = bookManager.searchBookByISBN(deleteISBN);
                                if (book == null) throw new BookNotFoundException();
                                bookManager.deleteBookByISBN(deleteISBN);
                                System.out.println("Book record deleted ");
                            }catch (BookNotFoundException e){
                                System.out.println(e);
                            }
                            break;
                        case 31 :
                            System.out.println("Get All Transactions are :");
                            bookTransactionManager.showAllTransactions();
                            break;
                        case 99 :
                            System.out.println("Thank you for using the library");
                            break;
                        default:
                            System.out.println("Entered invalid Key Please insure enter valid key !...... ");
                    }
                }while (isLibrarianChoice != 99);

            }


        }while (choice != 3);
        studentManager.writeToFile();
        bookManager.writeToFile();
        bookTransactionManager.writeToFile();
        sc.close();


    }
}