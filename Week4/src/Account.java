import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    Account() {
        balance = 0;
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }

    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     Method addTransaction.
     */

    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction newTransaction = new Transaction(operation, amount, balance);
            transitionList.add(newTransaction);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction newTransaction = new Transaction(operation, amount, balance);
            transitionList.add(newTransaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
        Method printTransaction.
     */

    public void printTransaction() {
        DecimalFormat f = new DecimalFormat("##.00");

        for (int i = 0; i < transitionList.size(); i++) {
            double amountPrinted = transitionList.get(i).getAmount();
            double balancePrinted = transitionList.get(i).getBalance();

            amountPrinted = Math.round(amountPrinted * 100.0) / 100.0;
            balancePrinted = Math.round(balancePrinted * 100.0) / 100.0;

            String type = "";

            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                type = ": Nap tien $";
            } else if (transitionList.get(i).getOperation().equals(Transaction.WITHDRAW)) {
                type = ": Rut tien $";
            }

            System.out.println("Giao dich " + (i + 1) + type + f.format(amountPrinted)
                    + ". So du luc nay: $" + f.format(balancePrinted) + '.');
        }
    }




}
