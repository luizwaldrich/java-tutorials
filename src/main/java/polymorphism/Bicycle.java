package polymorphism;

/**
 * In polymorphism, we can invoke methods with the same signature and identification but
 * with different behaviour/result
 * For example: the method getNumberOfWheels of Bicycle should return 2
 * You can also have polymorphism from Interfaces, as Vehicle implements Driver,
 * you can use the method "greetings" which return different greetings with the same name and signature
 */
public class Bicycle extends Vehicle {
    public int getNumberOfWheels() {
        return 2;
    }

    public String greetings() {
        return "Hello, I'm riding a bicycle!";
    }
}
