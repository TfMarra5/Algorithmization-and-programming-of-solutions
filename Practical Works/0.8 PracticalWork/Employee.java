/**
 * This is the abstract superclass
 * Abstraction: You cant make a new Employee
 * It is a general idea, not a specific person
 */
public abstract class Employee {
    // encapsulation: This variable is protected  subclasses can use it directly
    protected String name;

    // Encapsulation: This is private, so it can only be accessed using the public getEmployeeID method
    private int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    /**
     * abstraction: This is an abstract method
     * It forces subclasses to create their own version
     */
    public abstract void doWork();

    // a normal method
    public void goToMeeting() {
        System.out.println(name + " is going to a meeting.");
    }

    // encapsulation: A public getter for read
    // the private employeeID variable
    public int getEmployeeID() {
        return this.employeeID;
    }
}