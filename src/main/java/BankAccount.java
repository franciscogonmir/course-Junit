public class BankAccount {

    private double balance;
    private double miniumBalance;
    private boolean isActive;
    private String holder;

    public BankAccount(double balance, double miniumBalance) {
        this.balance = balance;
        this.miniumBalance = miniumBalance;
        this.isActive = true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMiniumBalance() {
        return miniumBalance;
    }

    public void setMiniumBalance(double miniumBalance) {
        this.miniumBalance = miniumBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double withDraw(double amount){
        if(balance - amount > miniumBalance){
            balance -= amount;
            return amount;
        }else{
            throw new RuntimeException();
        }
    }


    public double deposit(double amount){
        return balance += amount;
    }
}
