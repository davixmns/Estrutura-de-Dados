package beecrowd;

//Problema: https://www.beecrowd.com.br/judge/pt/problems/view/1195

import java.util.Scanner;

public class Beecrowd_1195 {
    static class No {
        public No esquerdo;
        public No direito;
        public int dado;

        public No(int dado) {
            this.dado = dado;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    static class Arvore {
        private No raiz;

        public void insert(int dado) {
            if (raiz == null)
                this.raiz = new No(dado);
            else
                insert(dado, this.raiz);
        }

        private void insert(int dado, No raiz) {
            if (dado < raiz.dado) {
                if (raiz.esquerdo == null)
                    raiz.esquerdo = new No(dado);
                else
                    insert(dado, raiz.esquerdo);

            } else if (dado > raiz.dado) {
                if (raiz.direito == null)
                    raiz.direito = new No(dado);
                else
                    insert(dado, raiz.direito);

            }
        }

        public void show(int escolha) {
            if (this.raiz != null) {
                switch (escolha) {
                    case 1 -> preOrdem(this.raiz);
                    case 2 -> emOrdem(this.raiz);
                    case 3 -> posOrdem(this.raiz);
                }
                System.out.println();
            }
        }

        private void preOrdem(No raiz) {
            System.out.print(raiz.dado + " ");
            if (raiz.esquerdo != null)
                preOrdem(raiz.esquerdo);
            if (raiz.direito != null)
                preOrdem(raiz.direito);
        }

        private void emOrdem(No raiz) {
            if (raiz.esquerdo != null)
                emOrdem(raiz.esquerdo);
            System.out.print(raiz.dado + " ");
            if (raiz.direito != null) {
                emOrdem(raiz.direito);
            }
        }

        private void posOrdem(No raiz) {
            if (raiz.esquerdo != null)
                posOrdem(raiz.esquerdo);
            if (raiz.direito != null) {
                posOrdem(raiz.direito);
            }
            System.out.print(raiz.dado + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ncasos = scanner.nextInt();
        for (int i = 1; i <= ncasos; i++) {
            Arvore arvore = new Arvore();

            scanner.nextInt();

            scanner.nextLine();

            String[] characters = scanner.nextLine().split(" ");

            for (String dado : characters) {
                arvore.insert(Integer.parseInt(dado));
            }

            System.out.println("Case" + i + ":");
            System.out.print("Pre.: ");
            arvore.show(1);
            System.out.print("In..: ");
            arvore.show(2);
            System.out.print("Post: ");
            arvore.show(3);

        }
    }
}
