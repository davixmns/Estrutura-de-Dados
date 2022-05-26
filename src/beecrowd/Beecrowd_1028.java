package beecrowd;

import java.io.IOException;
import java.util.Scanner;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1028

public class Beecrowd_1028 {

    public static int mdc(int a, int b) {
        if (b == 0) {
            return a;
        }

        int resto = a % b;
        a = b;
        b = resto;

        return mdc(a, b);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        do {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(mdc(a, b));
            n--;

        } while (n > 0);
    }
}
