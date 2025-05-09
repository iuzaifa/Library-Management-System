package pkg_exception;

public class BookNotFoundException extends Exception{


    public BookNotFoundException() {
    }

    @Override
    public String toString() {
        return "BookNotFoundException is generated {}";
    }
}
