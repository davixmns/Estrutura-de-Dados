package recursividade;

import java.util.Scanner;

public class Recursividade {
    public int potenciacao(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return x * potenciacao(x, y - 1);
        }
    }

    public int maiorDoVetor(int [] v, int i) {
        if (i == v.length - 1) {
            return v[i];

        } else {
            int a = v[i];
            int b = maiorDoVetor(v, i + 1);

            return Math.max(a, b); //retorna a variável maior
        }
    }

    public int fatorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recursividade recursividade = new Recursividade();

        boolean flag = true;

        do {
            System.out.println("1 - Fatorial\n2 - Fibonacci\n3 - Maior do vetor\n4 - Potenciação\n5 - Encerrar programa\n");
            System.out.print("Digite uma opção -> ");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                System.out.print("Digite um número -> ");
                System.out.printf("Fatorial = %d\n\n", recursividade.fatorial(scanner.nextInt()));

            } else if (escolha == 2) {
                System.out.print("Digite um número -> ");
                int numero = scanner.nextInt();
                System.out.println("\nSequencia Fibonacci:");

                for (int i = 0; i < numero; i++) {
                    System.out.print(recursividade.fibonacci(i) + " ");
                }

                System.out.println("\n");

            } else if (escolha == 3) {
                int[] v = {2, 4, 7, 34, 22, 3, 1, 22, 566, 5, 1000};

                System.out.printf("Maior do vetor = %d\n\n", recursividade.maiorDoVetor(v, 0));

            }else if(escolha == 4){
                System.out.print("Digite a base -> ");
                int base = scanner.nextInt();
                System.out.print("Digite o expoente -> ");
                int expoente = scanner.nextInt();

                System.out.printf("Resultado = %d\n\n", recursividade.potenciacao(base, expoente));
            }
            else if (escolha == 5) {
                flag = false;
            }
        } while (flag);
    }
}
