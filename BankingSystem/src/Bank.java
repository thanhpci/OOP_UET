import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();


    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Method.
     */
    public void readCustomerList(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] pieces = line.split(" ");
                if (pieces[1].equals(Account.CHECKING)) {
                    long accountNumber = Long.parseLong(pieces[0]);
                    double balance = Double.parseDouble(pieces[2]);
                    Account account = new CheckingAccount(accountNumber, balance);
                    customerList.get(customerList.size() - 1).addAccount(account);
                } else if (pieces[1].equalsIgnoreCase(Account.SAVINGS)) {
                    long accountNumber = Long.parseLong(pieces[0]);
                    double balance = Double.parseDouble(pieces[2]);
                    Account account = new SavingsAccount(accountNumber, balance);
                    customerList.get(customerList.size() - 1).addAccount(account);
                } else {
                    String name = line.substring(0, line.length() - 10);
                    long id = Long.parseLong(line.substring(line.length() - 9));
                    Customer customer = new Customer(id, name);
                    customerList.add(customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method.
     */
    public String getCustomersInfoByIdOrder() {
        String res = "";
        customerList.sort(new SortByNumber());
        for (Customer customer : customerList) {
            res = res + customer.getCustomerInfo() + "\n";
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * Method.
     */
    public String getCustomersInfoByNameOrder() {
        String res = "";
        customerList.sort(new SortByName());
        for (Customer customer : customerList) {
            res = res + customer.getCustomerInfo() + "\n";
        }
        return res.substring(0, res.length() - 1);
    }


}