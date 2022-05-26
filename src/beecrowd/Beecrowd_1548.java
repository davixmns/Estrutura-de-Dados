package beecrowd;

import java.util.Scanner;

public class Beecrowd_1548 {
    public static class No {
        private No proximo;
        private No anterior;
        private int posicao;
        private int pontos;

        public No(int pontos, int posicao) {
            this.proximo = null;
            this.anterior = null;
            this.posicao = posicao;
            this.pontos = pontos;
        }
    }

    public static class Fila {
        private No primeiro;
        private No ultimo;
        public int contador;

        public Fila() {
            this.primeiro = null;
            this.ultimo = null;
            this.contador = 0;
        }

        public void enqueue(int pontos, int posicao) {
            No novo = new No(pontos, posicao);

            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else if (novo.pontos >= this.primeiro.pontos) {
                this.primeiro.anterior = novo;
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if (novo.pontos <= this.ultimo.pontos) {
                this.ultimo.proximo = novo;
                novo.anterior = this.ultimo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;
                while (aux != null && novo.pontos <= aux.pontos) {
                    aux = aux.proximo;
                }
                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                novo.proximo = aux;
                aux.anterior = novo;
            }

            this.contador++;
        }

        public void show() {
            No aux = this.primeiro;
            while (aux != null) {
                System.out.print(aux.pontos + ":" + aux.posicao + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }

        public int getContadorNM() {
            int contadorNM = 0;
            No aux = this.primeiro;
            for (int i = 0; i < this.contador; i++) {
                if (aux.posicao == i) {
                    contadorNM++;
                }
                aux = aux.proximo;
            }
            return contadorNM;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ncasos = scanner.nextInt();

        for (int i = 0; i < ncasos; i++) {
            Fila fila = new Fila();

            int nAlunos = scanner.nextInt();

            scanner.nextLine();
            String[] linhaAlunos = scanner.nextLine().split(" ");

            for (int j = 0; j < nAlunos; j++) {
                fila.enqueue(Integer.parseInt(linhaAlunos[j]), j);
            }

            System.out.println(fila.getContadorNM());
        }
    }

}