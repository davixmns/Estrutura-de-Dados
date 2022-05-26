package beecrowd;

import java.util.Scanner;

public class Beecrowd_1110 {
    static class No {
        private Object dado;
        private No proximo;

        public No(Object dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class Fila {
        private No primeiro;
        private No ultimo;
        private int contador;

        public Fila() {
            this.primeiro = null;
            this.ultimo = null;
            this.contador = 0;
        }

        public void enqueue(Object dado) {
            No novo = new No(dado);
            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;
            } else {
                this.ultimo.proximo = novo;
                this.ultimo = novo;
            }
            this.contador++;
        }

        public Object dequeue() {
            No item = this.primeiro;
            this.primeiro = primeiro.proximo;
            this.contador--;
            return item.dado;
        }

        public void clear() {
            this.primeiro = null;
            this.ultimo = null;
            this.contador = 0;
        }

        public void exibirCartasDescartadas() {
            No aux = this.primeiro;
            System.out.print("Discarded cards: ");
            while (aux != null) {
                if (aux.dado.equals(this.ultimo.dado)) {
                    break;
                }
                System.out.print(aux.dado + ", ");
                aux = aux.proximo;
            }
            System.out.print(this.ultimo.dado);
            System.out.println();
        }

        public void exibirCartaFaltando() {
            System.out.println("Remaining card: " + this.ultimo.dado);
        }

        public int size() {
            return this.contador;
        }
    }

    public static void main(String[] args) {
        Fila cartas = new Fila();
        Fila cartasDescartadas = new Fila();
        Scanner scanner = new Scanner(System.in);

        int numeroDeCartas = scanner.nextInt();
        while (numeroDeCartas != 0) {
            for (int i = 1; i <= numeroDeCartas; i++) {
                cartas.enqueue(i);
            }

            while (cartas.size() > 1) {
                if (cartas.size() == 2) {
                    cartasDescartadas.enqueue(cartas.dequeue());
                } else {
                    cartasDescartadas.enqueue(cartas.dequeue());
                    cartas.enqueue(cartas.dequeue());
                }
            }

            cartasDescartadas.exibirCartasDescartadas();
            cartas.exibirCartaFaltando();

            cartas.clear();
            cartasDescartadas.clear();

            numeroDeCartas = scanner.nextInt();
        }
    }
}
