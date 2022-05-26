package beecrowd;

import java.util.Scanner;

public class Beecrowd_1068 {
    static class No {
        public No proximo;
        public Object dado;

        public No(Object dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class PilhaDinamica {
        public No topo;
        public int contador;

        public PilhaDinamica() {
            this.topo = null;
            this.contador = 0;
        }

        public void push(Object dado) {
            No novo = new No(dado);

            novo.proximo = topo;
            topo = novo;

            this.contador++;
        }

        public Object pop() {
            if (this.topo != null) {
                No item = this.topo;
                this.topo = this.topo.proximo;
                this.contador--;

                return item.dado;
            }
            return null;
        }

        public Object peek() {
            return this.topo.dado;
        }

        public void show() {
            No aux = this.topo;

            while (aux != null) {
                System.out.print(aux.dado + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }

        public int size() {
            return this.contador;
        }

        public boolean isEmpty() {
            return this.contador == 0;
        }

        public void clear() {
            this.topo = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            PilhaDinamica pilha = new PilhaDinamica();
            String linha = scanner.nextLine();
            boolean flag = false;

            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) == '(') {
                    pilha.push('(');

                } else if (linha.charAt(i) == ')') {
                    if (!pilha.isEmpty()) {
                        pilha.pop();
                    } else {
                        System.out.println("incorrect");
                        flag = true;
                    }
                }
            }

            if (!flag) {
                if (pilha.isEmpty()) {
                    System.out.println("correct");
                } else {
                    System.out.println("incorrect");
                }
            }
        }
    }
}
