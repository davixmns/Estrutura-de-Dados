package beecrowd;

import java.util.Scanner;

public class Beecrowd_2137 {
    static class No {
        public No proximo = null;
        public String dado;

        public No(String dado) {
            this.dado = dado;
        }
    }

    static class ListaDeLivros {
        public No primeiro = null;
        public No ultimo = null;

        private void add(String nome) {
            No novo = new No(nome);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else if (novo.dado.compareTo(this.primeiro.dado) <= 0) {
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if (novo.dado.compareTo(this.ultimo.dado) >= 0) {
                this.ultimo.proximo = novo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;

                while (aux != null && novo.dado.compareTo(aux.dado) > 0) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }
        }

        public void show() {
            No aux = this.primeiro;

            while (aux != null) {
                System.out.println(aux.dado);
                aux = aux.proximo;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int qtdLivros = scanner.nextInt();
            for (int i = 0; i < qtdLivros; i++) {
                ListaDeLivros listaDeLivros = new ListaDeLivros();
                for (int j = 0; j < qtdLivros; j++) {
                    String numero = scanner.next();
                    listaDeLivros.add(numero);
                }
                listaDeLivros.show();
            }
        }
    }
}
