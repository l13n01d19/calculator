import java.util.Scanner;

public class Main {
    public static void main(String[] agrs) {
        Scanner scan = new Scanner(System.in);
        Calculate cal = new Calculate(scan.nextLine());
        System.out.print(cal.calculation());
    }
}

