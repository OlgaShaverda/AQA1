package CurrencyTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyTask {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        double kurs = 25.90;

        if (args.length > 0) {
            //TODO: добавить проверку типа данных в args[0]
            kurs = Double.parseDouble(args[0]);
            System.out.printf("Today exchange rate is - %.2f \n", kurs);
        } else {
            System.out.printf("Today rate is not defined. Used rate by default is %.2f \n", kurs);
        }

        System.out.println("Enter the amount in UAH you want to convert");

        //TODO: добавить обработку пробелов
        while (scan.hasNext()) {
            double usd = calc(checker(scan.next().replaceAll(" ", "")), kurs);
            System.out.printf("Your USD amount is %.2f (exchange rate %.2f)\n", usd, kurs);
        }

    }

    // Result calculation
    public static double calc(double u, double k) {
        return u / k;
    }

    // Check input value
    public static double checker(String input) {
        try {
            double res = new Double(input);
            if (res > 0) {
                return res;
            } else {
                System.out.println("Provided amount should be >0");
            }
        } catch (NumberFormatException e) {
            checkQuit(input);
            System.out.println("Please use numeric symbols");
        }
        return checker(scan.next());
    }

    // Check string via regExp
    public static boolean checkQuitWithRegExp(String s) {
        Pattern p = Pattern.compile("(?i)quit");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    // Check quit
    public static void checkQuit(String s) {
        if (checkQuitWithRegExp(s)) {
            System.out.println("Bye-Bye!");
            System.exit(0);
        }
    }
}
pokpkopok
        njkjnkjnkjn
        lmklk
