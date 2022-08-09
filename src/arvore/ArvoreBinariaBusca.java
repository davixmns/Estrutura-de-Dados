package arvore;

import beecrowd.Beecrowd_1195;

import java.util.Scanner;

public class ArvoreBinariaBusca {
    private No raiz;

    public void insert(int dado) {
        if (this.raiz == null)
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
                case 1 -> exibirPreOrdem(this.raiz);
                case 2 -> exibirEmOrdem(this.raiz);
                case 3 -> exibirPosOrdem(this.raiz);
            }
        }
        System.out.println();
    }


    private void exibirPreOrdem(No raiz) {
        System.out.print(raiz.dado + " ");

        if (raiz.esquerdo != null) {
            exibirPreOrdem(raiz.esquerdo);
        }

        if (raiz.direito != null) {
            exibirPreOrdem(raiz.direito);
        }
    }

    private void exibirEmOrdem(No raiz) {
        if (raiz.esquerdo != null) {
            exibirEmOrdem(raiz.esquerdo);
        }

        System.out.print(raiz.dado + " ");

        if (raiz.direito != null) {
            exibirEmOrdem(raiz.direito);
        }
    }

    private void exibirPosOrdem(No raiz) {
        if (raiz.esquerdo != null) {
            exibirPosOrdem(raiz.esquerdo);
        }

        if (raiz.direito != null) {
            exibirPosOrdem(raiz.direito);
        }

        System.out.print(raiz.dado + " ");
    }

    public boolean contains(int dado) {
        if (this.raiz == null)
            return false;
        else
            return contains(dado, this.raiz);
    }

    public boolean contains(int dado, No raiz) {
        if (this.raiz.dado == dado) {
            return true;
        } else {
            if (dado < raiz.dado) {
                if (raiz.esquerdo == null)
                    return false;
                else
                    return contains(dado, raiz.esquerdo);

            } else if (dado > raiz.dado) {
                if (raiz.direito == null)
                    return false;
                else
                    return contains(dado, raiz.direito);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();

        Scanner scanner = new Scanner(System.in);

        System.out.println("numero de casos");
        int ncasos = scanner.nextInt();
        for (int i = 1; i <= ncasos; i++) {
            ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

            System.out.println("numero de elementos");
            scanner.nextInt();

            scanner.nextLine();

            System.out.println("Dados");
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
