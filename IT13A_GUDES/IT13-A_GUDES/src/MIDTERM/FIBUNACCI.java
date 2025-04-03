package midterm;

public class FIBUNACCI {

    public static void main(String[] args) {

        int n = 10;
        System.out.println("Fibonacci Sequence:");
        printFibonacci(0, n);
    }

    public static void printFibonacci(int i, int n) {
        if (i < n) {
            System.out.print(fibonacci(i) + " ");
            printFibonacci(i + 1, n);
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}