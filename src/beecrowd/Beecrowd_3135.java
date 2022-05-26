package beecrowd;

import java.util.Scanner;

public class Beecrowd_3135 {
    static class No {
        public String nome;
        public No proximo = null;

        public No(String nome) {
            this.nome = nome;
        }
    }

    static class ListaDeNomes {
        public No primeiro = null;
        public No ultimo = null;

        private void add(String nome) {
            No novo = new No(nome);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else if (this.primeiro.nome.compareTo(novo.nome) <= 0) { //primeiro
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if (this.ultimo.nome.compareTo(novo.nome) >= 0) { //Intermediario
                this.ultimo.proximo = novo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;

                while (aux != null && aux.nome.compareTo(novo.nome) > 0) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }
        }

        public boolean contains(String nome){
            No aux = this.primeiro;

            while (aux != null){
                if(aux.nome.equals(nome)){
                    return true;
                }
                aux = aux.proximo;
            }

            return false;
        }

        public boolean isEmpty(){
            return this.primeiro == null;
        }

        public void show(){
            No aux = this.primeiro;

            while (aux != null) {
                System.out.print(aux.nome + " ");
                aux = aux.proximo;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListaDeNomes listaDeNomes = new ListaDeNomes();
        Scanner scanner = new Scanner(System.in);

        int qtdNomes = scanner.nextInt();

        for (int i = 0; i < qtdNomes; i++) {
            String nome = scanner.next();

            if(listaDeNomes.isEmpty()){
                listaDeNomes.add(nome);
            } else {
                if(!listaDeNomes.contains(nome)){
                    listaDeNomes.add(nome);
                }
            }
        }

        listaDeNomes.show();
    }
}
