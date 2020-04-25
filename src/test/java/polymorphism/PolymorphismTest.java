package polymorphism;

import org.junit.Assert;
import org.junit.Test;

public class PolymorphismTest {

    @Test
    public void shouldInstantiateABicycleCorrectly() {
        Vehicle vehicle = new Bicycle();
        Assert.assertEquals(2, vehicle.getNumberOfWheels());
        Assert.assertEquals("Hello, I'm riding a bicycle!", vehicle.greetings());
    }

    @Test
    public void shouldInstantiateACarCorrectly() {
        Vehicle vehicle = new Car();
        Assert.assertEquals(4, vehicle.getNumberOfWheels());
        Assert.assertEquals("Hello, I'm driving a car!", vehicle.greetings());
    }
}
