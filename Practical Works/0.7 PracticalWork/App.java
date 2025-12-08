public class App {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("LV01-123", "Marija", 500.00);
        BankAccount a3 = new BankAccount(a2);
        a1.setOwnerName("Mario");
        a1.setAccountNumber("LV00-999");
        a1.setBalance(120.00);

        double a2After10 = a2.projectedBalance(10.0);

        boolean ok = BankAccount.transfer(a2, a1, 50.00);

        System.out.println("=== Objects ===");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println("\n=== Methods ===");
        System.out.println("a2 projected with 10% interest: " + String.format("%.2f", a2After10));
        System.out.println("Transfer 50.00 from a2 to a1 success? " + ok);
        System.out.println("a1 after transfer: " + a1);
        System.out.println("a2 after transfer: " + a2);

        System.out.println("\n=== equals & hashCode ===");
        System.out.println("a2.equals(a3)? " + a2.equals(a3)); 
        System.out.println("a1.equals(a2)? " + a1.equals(a2)); 
        System.out.println("a2.hashCode(): " + a2.hashCode());
        System.out.println("a3.hashCode(): " + a3.hashCode());
    }
}
