public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_DEPOSIT_SAVINGS = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Method.
     */
    public String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "- Kiểu giao dịch: Nạp tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "- Kiểu giao dịch: Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_CHECKING:
                return "- Kiểu giao dịch: Rút tiền vãng lai";
            case TYPE_WITHDRAW_SAVINGS:
                return "- Kiểu giao dịch: Rút tiền tiết kiệm";
            default:
                return "";
        }
    }

    /**
     * Method.
     */
    public String getTransactionSummary() {
        String initialBalanceString = String.format("%.2f", initialBalance);
        String amountString = String.format("%.2f", amount);
        String finalBalanceString = String.format("%.2f", finalBalance);

        return getTransactionTypeString(type) 
                + ". Số dư ban đầu: $" + initialBalanceString
                + ". Số tiền: $" + amountString
                + ". Số dư cuối: $" + finalBalanceString + ".";
    }
} 