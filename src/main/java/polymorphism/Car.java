package polymorphism;

/**
 * As the Car, Bicycle also extends from Vehicle and returns a number of Wheels.
 * But in this case, the number of wheels is 4.
 * Same method, same signature, different results.
 */
public class Car extends Vehicle {
    public int getNumberOfWheels() {
        return 4;
    }

    public String greetings() {
        return "Hello, I'm driving a car!";
    }
}
