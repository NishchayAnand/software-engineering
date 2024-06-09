// Situation: Couple Ryan and Monica have a joint bank account. They should be able to 
//            withdraw money from the bank's atm simultaneously.

class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        System.out.println("Balance before " + Thread.currentThread().getName() + " withdrawal: " + balance);
        System.out.println(Thread.currentThread().getName() + " Withdrawing...");
        balance = balance - amount;
        System.out.println("Balance after " + Thread.currentThread().getName() + " withdrawal: " + balance);
    }

}

public class RyanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public void makeWithdraw(int amount) {

        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw 10.");
            // Added sleep of 2 seconds to increase the time of transaction.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
        } else {
            System.out
                    .println("Sorry " + Thread.currentThread().getName() + ", not enough amount in your bank account.");
        }
    }

    @Override
    public void run() {
        makeWithdraw(10);
    }

    public static void main(String[] args) {
        // one instance of RyanAndMonicaJob means only one instance of the bank account.
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();

        // NOTE: Giving same job to both threads make sure that both threads access the
        // same account instance variable.

        // Ryan about to withdraw money from their joint bank account.
        Thread one = new Thread(theJob);
        one.setName("Ryan");
        one.start();

        // Monica about to withdraw money from their joint bank account.
        Thread two = new Thread(theJob);
        two.setName("Monica");
        two.start();

    }

}