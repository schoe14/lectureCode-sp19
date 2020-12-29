/**
 * Demonstrates higher order functions in Java.
 */
public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFunction TenX = new TenX();
        System.out.println(do_twice(TenX, 2));
    }
}
