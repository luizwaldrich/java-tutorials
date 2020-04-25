package inheritance;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class InheritanceTest {

    @Test
    public void shouldInstantiateAPersonCorrectly() {
        Person person = new Person();
        person.setFirstName("Luiz");
        person.setLastName("Waldrich");
        person.setBirthDay(LocalDate.of(1989, Month.JANUARY, 1));
        Assert.assertEquals("Luiz", person.getFirstName());
        Assert.assertEquals("Waldrich", person.getLastName());
        Assert.assertTrue(person.getAge() >= 31);
    }

    @Test
    public void shouldInstantiateAStudentCorrectly() {
        Student student = new Student();
        student.setFirstName("Luiz");
        student.setLastName("Waldrich");
        student.setBirthDay(LocalDate.of(1989, Month.JANUARY, 1));
        student.setRegistrationNumber("123456");
        Assert.assertEquals("Luiz", student.getFirstName());
        Assert.assertEquals("Waldrich", student.getLastName());
        Assert.assertEquals("123456", student.getRegistrationNumber());
        Assert.assertTrue(student.getAge() >= 31);
    }

    @Test
    public void shouldInstantiateAWorkerCorrectly() {
        BigDecimal salary = BigDecimal.valueOf(10000.00);
        Worker worker = new Worker();
        worker.setFirstName("Luiz");
        worker.setLastName("Waldrich");
        worker.setBirthDay(LocalDate.of(1989, Month.JANUARY, 1));
        worker.setSalary(salary);
        Assert.assertEquals("Luiz", worker.getFirstName());
        Assert.assertEquals("Waldrich", worker.getLastName());
        Assert.assertEquals(salary, worker.getSalary());
        Assert.assertTrue(worker.getAge() >= 31);
    }
}
