public class App {
    public static void main(String[] args) {

        // Creating a Manager object
        Employee manager = new Manager("Alice", 101, "Engineering");

        // Creating a Developer object
        Employee developer = new Developer("Bob", 102, "Java");

        System.out.println("--- Starting the workday ---");

        /**
         * Polymorphysm in code:
         * We call the same method 'doWork()' on the Manager.
         * Program run the Manager's specific version.
         */
        manager.doWork();
        
        // Inherited method
        manager.goToMeeting();


        /**
         * Polymorphysm in code:
         * We call the same method 'doWork()' there on the developer.
         * Program run the Developer's specific version.
         */
        developer.doWork();
        
        // Inherited method agai
        developer.goToMeeting();
    }
}