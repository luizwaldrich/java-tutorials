package inheritance;

/**
 * Students inherits from Person
 * So Student class has all the attributes from Person + the attributes from Student.
 * The advantage of inheritance is reuse of code,
 * as we don't need to redeclare attributes and methods that already exists in the parent class Person
 */
public class Student  extends Person {
    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
