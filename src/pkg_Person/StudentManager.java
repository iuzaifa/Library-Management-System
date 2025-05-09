package pkg_Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StudentManager {

    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;

    File studentFile = null;
    ArrayList<Student> studentList = null;

    public StudentManager(){
        studentFile = new File("student.dat");
        studentList = new ArrayList<Student>();

        if (studentFile.exists()){
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(studentFile));
                try {
                    studentList = (ArrayList<Student>)objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    ///  Add Students
    public void addStudent(Student student){
        studentList.add(student);
    }

    ///  Get Student by ROLl-Number
    public Student getStudentByRollNumber(int rollNumber){
        for (Student student : studentList){
            if (student.getRollNumber() == rollNumber){
                return student;
            }
        }
        return null;
    }

    ///  Get All Students
    public void getAllStudents(){
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    /// DELETE STUDENT BY ID -
    public boolean deleteStudentById(int stdId) {
        Iterator<Student> studentIterator = studentList.iterator();
//        Iterator<Student> studentIterator = (ListIterator<Student>) studentList.listIterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getRollNumber() == stdId) {
                studentList.remove(student);
                return true;
            }
        }
        return false;

    }

    public boolean updateStudentByRollNo(int updateRollNumber, String name, String email, String phone, String address, String dateOfBirth, int standard, String division) {
//        Iterator<Student> studentIterator = (ListIterator<Student>) studentList.listIterator();
        Iterator<Student> studentIterator = studentList.iterator();
        while (studentIterator.hasNext()){
            Student student = studentIterator.next();

            if (student.getRollNumber() == updateRollNumber){
                student.setName(name);
                student.setEmail(email);
                student.setPhone(phone);
                student.setDateOfBirth(dateOfBirth);
                student.setAddress(address);
                student.setDivision(division);
                student.setStandard(standard);
                return true;
            }
        }
        return false;
    }

    public Student get(int rollNo) {
        for (Student student : studentList){
            int rln = student.getRollNumber();
            if (rln == rollNo){
                return student;
            }
        }
        return null;
    }

    public void writeToFile(){
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(studentFile));
            objectOutputStream.writeObject(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
