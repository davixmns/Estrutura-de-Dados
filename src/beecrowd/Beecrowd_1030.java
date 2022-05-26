package beecrowd;

import java.util.Scanner;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1030

public class Beecrowd_1030 { //1030
    static class LendaFlaviousJosephus {
        public int suicidar(int nDePessoas, int salto) {
            if (nDePessoas == 1) {
                return 0;
            }

            return (suicidar(nDePessoas - 1, salto) + salto) % nDePessoas;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LendaFlaviousJosephus fj = new LendaFlaviousJosephus();

        int nc = scanner.nextInt();

        for (int i = 0; i < nc; i++) {
            int nDePessoas = scanner.nextInt();
            int salto = scanner.nextInt();

            System.out.printf("Case %d: %d\n", i + 1, fj.suicidar(nDePessoas, salto) + 1);
        }
    }
}
