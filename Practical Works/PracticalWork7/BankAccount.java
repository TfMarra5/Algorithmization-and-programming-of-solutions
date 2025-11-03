import java.util.Objects;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount() {
        this.accountNumber = "000000";
        this.ownerName = "Unknown";
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public BankAccount(BankAccount other) {
        this.accountNumber = other.accountNumber;
        this.ownerName = other.ownerName;
        this.balance = other.balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public double projectedBalance(double annualRatePercent) {
        double interest = balance * (annualRatePercent / 100.0);
        return balance + interest;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;    }

    public static boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || amount <= 0) return false;
        if (from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount(accountNumber: " + accountNumber +
               ", ownerName: " + ownerName +
               ", balance: " + String.format("%.2f", balance) + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) other;
        return Objects.equals(this.accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
