package pkg_Person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {

    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String dateOfBirth;



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    ///  Valid date of birth
    public void setDateOfBirth(String dateOfBirth) {
        boolean isValid = Pattern.matches("\\d{2}-\\d{2}-\\d{4}" , dateOfBirth);
        if (isValid ) {
            this.dateOfBirth = dateOfBirth;
        }else {
            this.dateOfBirth = "01-01-1999";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        boolean isPhone = Pattern.matches("[6-9]\\d{9}", phone);
        if (isPhone){
            this.phone = phone;
        }else this.phone = "9876543210";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        boolean isValid = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
        if (isValid) {
            this.email = email;
        }else this.email = "notuseremail@email.com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean isValid = Pattern.matches("^[A-Za-z]+(?:[ '-][A-Za-z]+)*$", name);
        if(isValid){
            this.name = name;
        }else{
            this.name = name;
        }
    }

    public Person() {
        super();
    }

    public Person(String name, String email, String phone, String address, String dateOfBirth) {
        super();
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.address = address;
        this.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
