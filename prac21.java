import java.util.Scanner;

interface AdvancedArithmetic {
    public int divisor_sum(int n);
}

class calledMyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}

public class prac21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of integer n: ");
        int n = sc.nextInt();
        calledMyCalculator o = new calledMyCalculator();
        int result = o.divisor_sum(n);
        System.out.println("The sum of divisors of " + n + " is: " + result);
    }
}