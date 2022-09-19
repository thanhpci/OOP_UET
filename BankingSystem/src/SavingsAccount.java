public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Method.
     */

    public void deposit(double amount) {
        double initialBalance = this.balance;

        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            return;
        }

        double finalBalance = this.balance;
        addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
            amount, initialBalance, finalBalance));
    }

    /**
     * Method.
     */

    public void withdraw(double amount) {
        double initialBalance = this.balance;
        if (amount > 1000 || initialBalance - amount < 5000) {
            return;
        }
        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            return;
        }
        double finalBalance = this.balance;
        addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                amount, initialBalance, finalBalance));
    }

}