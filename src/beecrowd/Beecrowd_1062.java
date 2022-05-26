package beecrowd;

import java.util.Objects;
import java.util.Scanner;

public class Beecrowd_1062 {
    static class No {
        public No proximo;
        public Object dado;

        public No(Object dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class FilaDinamica {
        public No primeiro;
        public No ultimo;
        public int contador;

        public FilaDinamica() {
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
            if (this.primeiro != null) {
                No item = this.primeiro;

                this.primeiro = this.primeiro.proximo;

                this.contador--;
                return item.dado;
            }

            return null;
        }

        public void show() {
            No aux = this.primeiro;
            while (aux != null) {
                System.out.print(aux.dado + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }

        public int size() {
            return this.contador;
        }

        public Object front() {
            if (this.primeiro != null) {
                return this.primeiro.dado;
            }
            return null;
        }

        public void clear() {
            this.primeiro = null;
            this.ultimo = null;
            this.contador = 0;
        }

        public boolean isEmpty() {
            return contador == 0;
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

            if (this.topo == null) {
                this.topo = novo;
            } else {
                novo.proximo = this.topo;
                this.topo = novo;
            }

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

        public void clear() {
            this.topo = null;
            this.contador = 0;
        }

        public int size() {
            return this.contador;
        }

        public Object peek() {
            if (this.topo != null) {
                return this.topo.dado;
            }
            return null;
        }

        public boolean isEmpty() {
            return this.contador == 0;
        }

        public void show() {
            No aux = this.topo;

            while (aux != null) {
                System.out.print(aux.dado + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaDinamica estacao = new PilhaDinamica();
        FilaDinamica linhaA = new FilaDinamica();
        FilaDinamica linhaB = new FilaDinamica();

        while (true) {
            int nVagoes = scanner.nextInt();
            scanner.nextLine();

            if (nVagoes == 0) {
                break;
            }

            while (true) {
                for (int i = 1; i <= nVagoes; i++) {
                    linhaA.enqueue(i);
                }

                String[] vetorDeVagoes = scanner.nextLine().split(" ");

                if (vetorDeVagoes[0].equals("0")) {
                    linhaA.clear();
                    linhaB.clear();
                    estacao.clear();
                    break;

                } else {
                    for (String vagao : vetorDeVagoes) {
                        linhaB.enqueue(vagao);
                    }

                    estacao.push(linhaA.dequeue());
                    while (true) {
                        if (!estacao.isEmpty() && String.valueOf(estacao.peek()).equals(String.valueOf(linhaB.front()))) {
                            estacao.pop();
                            linhaB.dequeue();

                        } else {
                            if (!linhaA.isEmpty()) {
                                estacao.push(linhaA.dequeue());
                            }
                        }

                        if (linhaA.isEmpty() && linhaB.isEmpty() && estacao.isEmpty()) {
                            System.out.println("Yes");
                            linhaA.clear();
                            linhaB.clear();
                            estacao.clear();
                            break;
                        } else if (linhaA.isEmpty() && !String.valueOf(estacao.peek()).equals(String.valueOf(linhaB.front()))) {
                            System.out.println("No");
                            linhaA.clear();
                            linhaB.clear();
                            estacao.clear();
                            break;
                        }
                    }
                }
            }
        }
    }
}
