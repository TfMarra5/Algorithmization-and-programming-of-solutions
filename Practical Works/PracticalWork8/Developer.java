// Inheritance: This class also extends Employee just like Manager.

public class Developer extends Employee {

    // This atributes to Developer
    private String programmingLanguage;

    public Developer(String name, int employeeID, String programmingLanguage) {
        super(name, employeeID);
        this.programmingLanguage = programmingLanguage;
    }


    // Polymorphyssm: This is the overridden for doWork method.
    @Override
    public void doWork() {
        System.out.println("Developer " + name + " is writing code in " + programmingLanguage + ".");
    }
}