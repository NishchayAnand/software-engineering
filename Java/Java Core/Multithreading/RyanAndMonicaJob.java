/*
    Problem Statement: Couple Ryan and Monica have a joint bank account. They should be 
                       able to withdraw money from the bank's ATM simultaneously. Make sure
                       that the current information is displayed each time a transaction
                       happens.

    Solution:

    - Use synchronized keyword on the makeWithdraw() method to make sure one thread at a 
      time can access it. 

    - We could have synchronized the getters (checkBalance()) and setters (withdraw()) 
      methods, but, we could have still left with the synchronization problem. For example,
      Ryan would have checked the balance and then immediately exited the method and 
      returned the key. Of course, he would grab the key again so that he can call the 
      synchronized withdraw() method, but in before he does that, it could be possible
      that Monica comes in and also check the balance before Ryan has a chance to 
      completes his withdrawal. Hence, synchronizing all the access methods is probably
      a good idea, to prevent other threads from getting in, but you still need to 
      synchronize the methods that have statements that must execute as one atomic unit. 

    - NOTE: Put the lock on the method that does the banking transaction, not on the bank
            account itself.  

*/

class BankAccount {

    private int balance = 100;

    public int checkBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

}

public class RyanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public void makeWithdraw(int amount) {

        int balance = account.checkBalance();
        System.out.println("Current Balance: $" + balance);

        if (account.checkBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing $10...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.withdraw(amount);
            balance = account.checkBalance();
            System.out.println("Balance after " + Thread.currentThread().getName() + " withdrawal: $" + balance);
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