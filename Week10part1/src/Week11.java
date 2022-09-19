import java.util.List;

public class Week11 {

    /**
    *Method sortGeneric.
    */
    public static <T extends Comparable<T>> List sortGeneric(List<T> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).compareTo(arr.get(i)) < 0) {
                    T temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }

        return arr;
    }
}
