# Library-Management-System


### **Key Features of the Library Management System**

1. **Dual-Role Access: Student and Librarian**

   * Allows users to log in either as a student or librarian, offering different functionalities based on role.

2. **Student Authentication by Roll Number**

   * Students must enter a valid roll number to access services; system verifies existence using `StudentManager`.

3. **Book Viewing and Search (Student & Librarian)**

   * View all books.
   * Search by **ISBN** or **Subject**.

4. **Book Issue and Return (Student)**

   * Students can issue a book (if available).
   * Return issued books and update inventory.

5. **Student Record Management (Librarian)**

   * View all students.
   * Search student by roll number.
   * Add, update, or delete student records.

6. **Book Record Management (Librarian)**

   * View all books.
   * Search book by ISBN.
   * Add new books with full details.
   * Update book information.
   * Delete books from inventory.

7. **Transaction Tracking**

   * View all book issue/return transactions for tracking and reporting.

8. **Exception Handling**

   * Graceful handling of missing students (`StudentNotFoundException`) and books (`BookNotFoundException`).

9. **Persistent Data Storage**

   * At program exit, it writes all student, book, and transaction data to files for persistence.

10. **Console-Based Interactive Menu**

* Easy navigation via menu-driven console interface for both roles.

---

