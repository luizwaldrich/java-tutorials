package inheritance;

import java.math.BigDecimal;

/**
 * As the Student example, Worker also inherits from Person
 * But different from Student, a Worker has salary
 */
public class Worker extends Person {
    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
