package beecrowd;

import java.util.Scanner;

public class Beecrowd_2381 {
    static class No {
        public No proximo = null;
        public String nome;

        public No(String dado) {
            this.nome = dado;
        }
    }

    static class ListaDeAlunos {
        public No primeiro = null;
        public No ultimo = null;
        public int contador = 0;

        public int decimalCompare(String str1, String str2) {
            int n1 = Character.codePointAt(str1, 0);
            int n2 = Character.codePointAt(str2, 0);

            if (n1 == n2) {
                int n3 = Character.codePointAt(str1, 1);
                int n4 = Character.codePointAt(str2, 1);

                return Integer.compare(n3, n4);
            }

            return Integer.compare(n1, n2);
        }

        private void add(String nome) {
            No novo = new No(nome);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else if (decimalCompare(novo.nome, this.primeiro.nome) <= 0) {
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if (decimalCompare(novo.nome, this.ultimo.nome) >= 0) {
                this.ultimo.proximo = novo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;

                while (aux != null && decimalCompare(novo.nome, aux.nome) > 0) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }

        }


        public void show() {
            No aux = this.primeiro;

            while (aux != null) {
                System.out.print(aux.nome + " ");
                aux = aux.proximo;
            }

            System.out.println();
        }

        public String get(int indice) {
            No aux = this.primeiro;
            int c = 0;

            while (aux != null) {
                if (c == indice) {
                    return aux.nome;
                }
                aux = aux.proximo;
                c++;
            }

            return "nop";
        }

    }

    public static void main(String[] args) {
        ListaDeAlunos listaDeAlunos = new ListaDeAlunos();
        Scanner scanner = new Scanner(System.in);

        String[] txt = scanner.nextLine().split(" ");
        int nAlunos = Integer.parseInt(txt[0]);
        int sorteado = Integer.parseInt(txt[1]) -1;

        for (int i = 0; i < nAlunos; i++) {
            listaDeAlunos.add(scanner.next());
        }

        System.out.println(listaDeAlunos.get(sorteado));
    }
}
