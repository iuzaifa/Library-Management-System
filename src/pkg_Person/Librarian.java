package pkg_Person;

public class Librarian extends Person {


    private int id;
    private String dateOfJoining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Librarian(int id, String dateOfJoining) {
        this.id = id;
        this.dateOfJoining = dateOfJoining;
    }

    public Librarian(String name, String email, String phone, String address, String dateOfBirth, int id, String dateOfJoining) {
        super(name, email, phone, address, dateOfBirth);
        this.id = id;
        this.dateOfJoining = dateOfJoining;
    }

    public Librarian() {
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
