package beecrowd;

import java.util.Objects;
import java.util.Scanner;

public class Beecrowd_2174 {
    static class No {
        public No proximo = null;
        public String nome;

        public No(String nome) {
            this.nome = nome;
        }
    }

    static class ListaDePomekon {
        private No primeiro = null;
        private No ultimo = null;
        private int contadorDePomekons = 0;
        private int metaDePomekons = 151;

        private void add(String nome) {
            No novo = new No(nome);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else {
                this.ultimo.proximo = novo;
                this.ultimo = novo;
            }

            contadorDePomekons++;
        }

        private boolean contains(String nome) {
            No aux = this.primeiro;

            while (aux != null) {
                if (Objects.equals(aux.nome, nome)) {
                    return true;
                }
                aux = aux.proximo;
            }

            return false;
        }

        public void adicionarPomekon(String nome) {
            if (this.primeiro == null) {
                add(nome);
            } else {
                if (!contains(nome)) {
                    add(nome);
                }
            }
        }

        public int numeroDePomekonsFaltando() {
            return metaDePomekons - contadorDePomekons;
        }

    }
    public static void main(String[] args) {
        ListaDePomekon l = new ListaDePomekon();
        Scanner scanner = new Scanner(System.in);

        int ncasos = scanner.nextInt();

        for (int i = 0; i < ncasos; i++) {
            String nome = scanner.next();
            l.adicionarPomekon(nome);
        }

        System.out.printf("Falta(m) %d pomekon(s).\n", l.numeroDePomekonsFaltando());
    }
}
