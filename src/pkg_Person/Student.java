package pkg_Person;

public class Student extends Person {

    private int rollNumber;
    private int standard;
    private String division;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Student(int rollNumber, int standard, String division) {
        this.rollNumber = rollNumber;
        this.standard = standard;
        this.division = division;
    }

    public Student(String name, String email, String phone, String address, String dateOfBirth, int rollNumber, int standard, String division) {
        super(name, email, phone, address, dateOfBirth);
        this.rollNumber = rollNumber;
        this.standard = standard;
        this.division = division;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", standard=" + standard +
                ", division='" + division + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
