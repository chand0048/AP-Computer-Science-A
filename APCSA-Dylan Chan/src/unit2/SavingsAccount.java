package unit2;

public class SavingsAccount
{
    private double balance, interest;

    /**
     * Constructs a bank account with a zero balance.
     */
    public SavingsAccount()
    {
        balance = 0;
        interest = 0;
    }

    /**
     * Constructs a bank account with a given balance.
     *
     * @param initialBalance the initial balance
     */
    public SavingsAccount(double initialBalance, double interest)
    {
        balance = initialBalance;
        this.interest = interest;
    }

    /**
     * Deposits money into the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     * Gets the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
    
    public double getInterest()
    {
    	return interest;
    }
    
    /**
     * Adds interest to account
     */
    public void addInterest()
    {
    	balance = balance * (interest * 0.01 + 1);
    }
}