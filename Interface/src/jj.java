import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class jj {
    public static void main(String[] args) {
////        int[] arr =  new int[]{1, 2, -4, -4, 5, 0};
//        List<Integer> array = new ArrayList<>();
//        array.add(1);
//        array.add(-1);
//        plusMinus(array);
        staircase(6);
    }
    public static void plusMinus(List<Integer> arr) {
        double countPositive = 0;
        double countNegative = 0;
        double countZero = 0;
        double size = arr.size();
        for (Integer n : arr) {
            if (n == 0) countZero++;
            else if (n < 0) countNegative++;
            else countPositive++;
        }

        System.out.println(String.format("%.6f", countPositive/size));
        System.out.println(String.format("%.6f", countNegative/size));
        System.out.println(String.format("%.6f", countZero/size));

    }
    public static void miniMaxSum(List<Integer> arr) {
        long max = arr.get(0), min = arr.get(0);
        int sum = 0;
        for (int number : arr) {
            if (max < number) max = number;
            if (min > number) min = number;
            sum += number;
        }

        System.out.print(sum - max);
        System.out.println(" " + (sum - min));
    }

}
