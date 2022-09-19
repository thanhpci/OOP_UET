
public class CheckingAccount extends Account {

    CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Method.
     */
    public void withdraw(double amount) {
        double prevBalance = getBalance();
        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
            return;
        }
        Transaction newTransaction = new Transaction(
                Transaction.TYPE_WITHDRAW_CHECKING,
                amount, prevBalance, getBalance());
        addTransaction(newTransaction);
    }

    /**
     * Method.
     */
    public void deposit(double amount) {
        double prevBalance = getBalance();
        try {
            doDepositing(amount);
        } catch (InvalidFundingAmountException e) {
            e.printStackTrace();
            return;
        }
        Transaction newTransaction = new Transaction(
                Transaction.TYPE_DEPOSIT_CHECKING,
                amount, prevBalance, getBalance());
        addTransaction(newTransaction);
    }

}