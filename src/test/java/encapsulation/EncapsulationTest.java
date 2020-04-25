package encapsulation;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class EncapsulationTest {

    @Test
    public void shouldInstantiateAPersonCorrectly() {
        Person person = new Person();
        person.setName("Luiz Waldrich");
        person.setBirthDay(LocalDate.of(1989, Month.JANUARY, 18));
        person.setPassportNumber("ABC123");
        // today I'm 31 but you may run in the future, so I'll test as >=
        Assert.assertTrue(person.getAge() >= 31);
    }

    @Test
    public void shouldReturnAgeZeroWhenBirthdayIsNull() {
        Person person = new Person();
        person.setName("Luiz Waldrich");
        person.setPassportNumber("ABC123");
        Assert.assertTrue(person.getAge() == 0);
    }
}
