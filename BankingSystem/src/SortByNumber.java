import java.util.Comparator;

public class SortByNumber implements Comparator<Customer> {
    public int compare(Customer x, Customer y) {
        int n = (int) (x.getIdNumber() - y.getIdNumber());
        return n;
    }
}