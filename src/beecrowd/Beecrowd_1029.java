package beecrowd;

import java.util.Scanner;
import java.io.IOException;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1029

public class Beecrowd_1029 {
    static class Fibonacci {
        private int calls = 0;

        public void setCalls(int calls) {
            this.calls = calls;
        }

        public int getCalls() {
            return calls;
        }

        public int fib(int n) {
            this.calls += 1;
            if (n == 0 || n == 1) {
                return n;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Fibonacci f = new Fibonacci();

        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int in = scanner.nextInt();
            int sum = f.fib(in);
            int calls = f.getCalls() - 1;
            System.out.printf("fib(%d) = %d calls = %d\n", in, calls, sum);
            f.setCalls(0);
        }
    }
}