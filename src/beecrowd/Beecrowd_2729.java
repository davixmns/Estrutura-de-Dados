package beecrowd;

import java.util.Scanner;

public class Beecrowd_2729 {
    static class No {
        public String nome;
        public No proximo = null;

        public No(String nome) {
            this.nome = nome;
        }
    }

    static class ListaDeCompras {
        public No primeiro = null;
        public No ultimo = null;

        public int decimalCompare(String str1, String str2, int indice) {
            int d1 = Character.codePointAt(str1, indice);
            int d2 = Character.codePointAt(str2, indice);

            if(indice < 7) {
                if (d1 == d2) {
                    decimalCompare(str1, str2, indice + 1);
                }
            }

            return Integer.compare(d1, d2);
        }

        private void add(String nome) {
            No novo = new No(nome);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else if (decimalCompare(novo.nome, this.primeiro.nome, 0) <= 0) {
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if (decimalCompare(novo.nome, this.ultimo.nome, 0) >= 0) {
                this.ultimo.proximo = novo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;

                while (aux != null && decimalCompare(novo.nome, aux.nome, 0) > 0) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }

        }

        public boolean contains(String nome) {
            No aux = this.primeiro;

            while (aux != null) {
                if (aux.nome.equals(nome)) {
                    return true;
                }
                aux = aux.proximo;
            }

            return false;
        }

        public void adicionarProduto(String nome) {
            if (this.primeiro == null) {
                add(nome);

            } else {
                if (!contains(nome)) {
                    add(nome);
                }
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

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nlistas = scanner.nextInt() + 1;

        for (int i = 0; i < nlistas; i++) {
            ListaDeCompras l = new ListaDeCompras();
            String[] vNomes = scanner.nextLine().split(" ");

            for (String nome : vNomes) {
                l.adicionarProduto(nome);
            }

            l.show();
        }
    }
}
