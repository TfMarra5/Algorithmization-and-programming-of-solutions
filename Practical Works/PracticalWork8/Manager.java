/**
 * Inheritance: This class extends Employee.
 * It gets all the methods and attributes from Employee
 */
public class Manager extends Employee {

    // This attribute for Manager
    private String department;

    public Manager(String name, int employeeID, String department) {
        // 'super' calls the constructor of the parent => Employee
        super(name, employeeID);
        this.department = department;
    }

    
    // Polymorphism: This is the overridden method.
    @Override
    public void doWork() {
        System.out.println("Manager " + name + " is holding meetings and planning.");
    }

    // A method for only Manager
    public void approveTimeOff() {
        System.out.println(name + " is approving time off requests.");
    }
}