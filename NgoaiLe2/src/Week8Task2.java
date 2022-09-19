import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        String s = null;
        System.out.println(s.length());
    }

    /**
    Method.
    */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
            return "Không có lỗi";
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
    }


    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int [] a = {1, 2, 3};
        System.out.println(a[10]);
    }

    /**
     Method.
     */

    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
            return "Không có lỗi";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
    }

    public void arithmeticEx() throws ArithmeticException {
        int a = 10 / 0;
    }

    /**
     Method.
     */

    public String arithmeticExTest() {
        try {
            arithmeticEx();
            return "Không có lỗi";
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
    }


    public void fileNotFoundEx() throws FileNotFoundException {
        FileReader fileReader = new FileReader("abc.txt");
    }

    /**
     Method.
     */

    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "Không có lỗi";
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
    }

    public void ioEx() throws IOException {
        FileReader fileReader = new FileReader("abc.txt");
    }


    /**
     Method.
     */

    public String ioExTest() {
        try {
            ioEx();
            return "Không có lỗi";
        } catch (IOException e) {
            return "Lỗi IO";
        }
    }




}
