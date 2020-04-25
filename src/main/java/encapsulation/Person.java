package encapsulation;

import java.time.LocalDate;
import java.time.Period;

/**
 * Example class of encapsulation
 * You need encapsulation to control the access to the class' attributes and methods
 * The advantages of encapsulation is to protect the data for being manipulated inside the class
 * and where the class can be manipulated.
 * To access the attributes values we use a concept of getters and setters
 * Note that "age" attribute cannot be set, you can only get the value calculated from the birthday
 * Also note that the class is "public" which means that it can be accessed anywhere in any other package
 */
public class Person {
    private String name;
    private String passportNumber;
    private LocalDate birthDay;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getAge() {
        return age != null && age != 0 ? age : calculateAge();
    }

    private Integer calculateAge() {
        return birthDay != null ? Period.between(birthDay, LocalDate.now()).getYears() : 0;
    }
}
