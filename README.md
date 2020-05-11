# Java Tutorials

## What you will find here:

### Challenges

The [Challenges](src/main/java/challenges/Challenges.java) class holds some challenges that I had to do in interviews without code complete or searching on Google. 

You can also look into [ChallengesTest](src/test/java/challenges/ChallengesTest.java) to see how it works.

### Encapsulation
The [Person](src/main/java/encapsulation/Person.java) class is an example of encapsulation. The advantage of using encapsulation is to control the access to the class' attributes and methods and where the class can be manipulated.

You can also look into [EncapsulationTest](src/test/java/encapsulation/EncapsulationTest.java) to see how it works.

### Inheritance
The [inheritance](src/main/java/inheritance) package contains 3 classes that demonstrate an example of inheritance. Both [Student](src/main/java/inheritance/Student.java) and [Worker](src/main/java/inheritance/Worker.java) classes inherits from [Person](src/main/java/inheritance/Person.java). It means that every method or attribute in [Person](src/main/java/inheritance/Person.java) class will also belong to [Student](src/main/java/inheritance/Student.java) and [Worker](src/main/java/inheritance/Worker.java). The main advantage of using inheritance is the reuse of code.

You can also look into [InheritanceTest](src/test/java/inheritance/InheritanceTest.java) to see how it works.

### Polymorphism
The [polymorphism](src/main/java/polymorphism) package contains 3 classes and 1 interface that demonstrate an example of polymorphism. In this case, both [Car](src/main/java/polymorphism/Car.java) and [Bicycle](src/main/java/polymorphism/Bicycle.java) extends [Vehicle](src/main/java/polymorphism/Vehicle.java) and [Vehicle](src/main/java/polymorphism/Vehicle.java) implements the [Driver](src/main/java/polymorphism/Driver.java) interface. As you can see, [Car](src/main/java/polymorphism/Car.java) and [Bicycle](src/main/java/polymorphism/Bicycle.java) have the same methods names and signatures, but they return different values which determines the main concept of Polymorphism. It helps programmers to reuse the code, classes, methods written once, tested and implemented.

You can also look into [PolymorphismTest](src/test/java/polymorphism/PolymorphismTest.java) to see how it works.

### Selenium WebDriver and Page Objects
In [selenium.google.pages](src/main/java/selenium/google/pages) package you can see two Pages of Google: The [HomePage](src/main/java/selenium/google/pages/HomePage.java) and the [ResultsPage](src/main/java/selenium/google/pages/ResultsPage.java). They are similar: 
- implements `PageFactory.initElements` into constructor, passing driver and the class as parameters. This will map all elements listed as this class attributes;
- they have `WebElement` attributes which represent an element in a page. Eg.: Input, Button, Link, Div, etc.

You can also look into [GoogleTest](src/test/java/selenium/google/GoogleTest.java) to see how it works. Note that this Test Unit extends [TestBase](src/test/java/selenium/TestBase.java) which contains:
- `setup()`: annotated with `@Before`, any browser configuration, implicit waits and instantiation of `WebDriver` will happen before any `@Test` begins;
- `cleanup()`: annotated with `@After`, it closes the `WebDriver` in the correct way after every `@Test`;
- `getDriver()`: a method to return an already instantiated `WebDriver`;
 
Note: For now, [resources](src/test/resources) just contains the webDriver for Windows.

### REST-API
There's a CrudUserApi under [rest](src/main/java/rest). This User Crud is just an example of a REST API for Create, Read, Update and Delete an User. Important points of this application:
- The [domain](src/main/java/rest/domain) package holds all the requirements of this app
- Under [UserApi](src/main/java/rest/domain/interfaces/UserApi.java) interface, you can see how the controllers will be implemented
- In [UserController](src/main/java/rest/controllers/UserController.java) you can see the implementation of the [UserApi](src/main/java/rest/domain/interfaces/UserApi.java) interface
- Take a look into [UserControllerTest](src/test/java/rest/controllers/UserControllerTest.java) to see how the calls for this API are done
- This App has customized [Exception](src/main/java/rest/infrastructure/UserException.java) which are handled by an [ExceptionHandler](src/main/java/rest/infrastructure/UserExceptionHandler.java)