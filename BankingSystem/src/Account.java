import java.util.List;
import java.util.Objects;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected List<Transaction> transactionList;
    protected long accountNumber;
    protected double balance;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);


    Account() {
        transactionList = new java.util.ArrayList<Transaction>();
        this.accountNumber = 0;
        this.balance = 0;
    }

    Account(long accountNumber, double balance) {
        transactionList = new java.util.ArrayList<Transaction>();
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Method.
     */
    public String getTransactionHistory() {
        String result = "Lịch sử giao dịch của tài khoản " + accountNumber + ":" + "\n";
        for (Transaction transaction : transactionList) {
            result += transaction.getTransactionSummary() + "\n";
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * Method.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return this.accountNumber == account.accountNumber;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Method.
     */
    public void doWithdrawing(double amount)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (amount > 0) {
            if (amount <= getBalance()) {
                balance -= amount;
            } else {
                String amountFormatted = String.format("%.2f", amount);
                throw new InsufficientFundsException(
                        "Số dư tài khoản không đủ $" 
                                + amountFormatted
                                + " để thực hiện giao dịch");
            }
        } else {
            String amountFormatted = String.format("%.2f", amount);
            throw new InvalidFundingAmountException(
                    "Số tiền không hợp lệ: $" + amountFormatted);
        }
    }

    /**
     * Method.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount > 0) {
            balance += amount;
        } else {
            String amountFormatted = String.format("%.2f", amount);
            throw new InvalidFundingAmountException(
                    "Số tiền không hợp lệ: $" + amountFormatted);
        }
    }



} 