import java.util.Comparator;

public class SortByName implements Comparator<Customer> {
    public int compare(Customer x, Customer y) {
        return x.getFullName().compareTo(y.getFullName());
    }
}