import static java.lang.Math.abs;

public class Solution {
    private int numerator;
    private int denominator;

    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    /**
     method setDenominator.
     */

    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * method reduce.
     * */

    public Solution reduce() {
        int a = abs(numerator);
        int b = abs(denominator);
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        numerator = numerator / a;
        denominator  = denominator / a;

        return this;
    }

    /**
     * method add.
     */

    public Solution add(Solution other) {
        numerator = numerator * other.denominator + other.numerator * denominator;
        denominator = denominator * other.denominator;

        return this.reduce();
    }

    /**
     * method subtract.
     */
    public Solution subtract(Solution other) {
        numerator = numerator * other.denominator - other.numerator * denominator;
        denominator = denominator * other.denominator;

        return this.reduce();
    }

    /**
     * method multiply.
     */
    public Solution multiply(Solution other) {
        numerator = numerator * other.numerator;
        denominator = denominator * other.denominator;
        return this.reduce();
    }

    /**
     * method divide.
     */

    public Solution divide(Solution other) {

        if (other.numerator != 0 && denominator != 0) {
            numerator = numerator * other.denominator;
            denominator = denominator * other.numerator;
        }
        return this.reduce();
    }

    /**
     * method equals.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            if (other.reduce().numerator == this.reduce().numerator
                    && other.reduce().denominator == this.reduce().denominator) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution ps = new Solution(6, 7);
        System.out.println(ps.numerator + " " + ps.denominator);
    }

}

