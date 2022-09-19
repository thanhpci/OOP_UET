import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Solution {
    public static void main(String [] args) {
//        System.out.println(fibonacci(5));
        System.out.println(gcd(-5, -7));
        System.out.println(isPrime(6));
    }

    /**
     *Ham fibonaci.
     */


    public static long fibonacci(long n) {

        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }

        long fn2 = 0;
        long fn1 = 1;
        long fn = fn1 + fn2;

        for (int i = 3; i <= n; i++) {

            fn2 = fn1;
            fn1 = fn;
            if ((Long.MAX_VALUE - fn1) <= fn2) {
                return Long.MAX_VALUE;
            }

            fn = fn1 + fn2;

        }
        return fn;
    }

    /**
        uoc chung lon nhat.
    */


    public static int gcd(int a, int b) {
        a = abs(a);
        b = abs(b);
        int min = (a < b) ? a : b;
        int max = (a > b) ? a : b;

        if (min == 0) {
            return 1;
        }

        for (int i = abs(min); i >= 0; i--) {
            if (max % i == 0) {
                return i;
            }
        }

        return 1;
    }
/**


    function check prime.
*/

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i < sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }




}
