package beecrowd;

import java.util.Scanner;

public class Beecrowd_1340 {
    static class No {
        private int dado;
        private No proximo;
        private No anterior;

        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    static class Pilha {
        private No topo;
        private int contador;

        public Pilha() {
            this.topo = null;
            this.contador = 0;
        }

        public void push(int dado) {
            No novo = new No(dado);
            if (this.topo == null) {
                this.topo = novo;
            } else {
                novo.proximo = this.topo;
                this.topo.anterior = novo;
                this.topo = novo;
            }
            this.contador++;
        }

        public int pop() {
            if (this.contador != 0) {
                No item = this.topo;
                this.topo = this.topo.proximo;
                this.contador--;
                return item.dado;
            }
            return -1;
        }

        public int peek() {
            return this.topo.dado;
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

        public void enqueue(int dado) {
            No novo = new No(dado);
            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;
            } else {
                this.ultimo.proximo = novo;
                novo.anterior = this.ultimo;
                this.ultimo = novo;
            }
            this.contador++;
        }

        public int dequeue() {
            if (this.contador != 0) {
                No item = this.primeiro;
                this.primeiro = this.primeiro.proximo;
                this.contador--;
                return item.dado;
            }
            return -1;
        }

        public int front(){
            return this.primeiro.dado;
        }
    }

    static class FilaP {
        private No primeiro;
        private No ultimo;
        private int contador;

        public FilaP() {
            this.primeiro = null;
            this.ultimo = null;
            this.contador = 0;
        }

        public void enqueue(int dado) {
            No novo = new No(dado);
            if (this.primeiro == null) {
                this.primeiro = novo;
                this.ultimo = novo;

            } else {
                if (novo.dado >= this.primeiro.dado) {
                    novo.proximo = this.primeiro;
                    this.primeiro.anterior = novo;
                    this.primeiro = novo;

                } else if (novo.dado <= this.ultimo.dado) {
                    novo.anterior = this.ultimo;
                    this.ultimo.proximo = novo;
                    this.ultimo = novo;

                } else {
                    No aux = this.primeiro;
                    while (aux != null && novo.dado <= aux.dado){
                        aux = aux.proximo;
                    }
                    aux.anterior.proximo = novo;
                    novo.anterior = aux.anterior;
                    novo.proximo = aux;
                    aux.anterior = novo;
                }
            }
            this.contador++;
        }

        public int dequeue(){
            if(this.contador!=0){
                No item = this.primeiro;
                this.primeiro = this.primeiro.proximo;
                this.contador--;
                return item.dado;
            }
            return -1;
        }

        public int front(){
            return this.primeiro.dado;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            Pilha pilha = new Pilha();
            Fila fila = new Fila();
            FilaP filaPrioridade = new FilaP();

            int contadorPilha = 0;
            int contadorFila = 0;
            int contadorFilaPrioridade = 0;

            int ncasos = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < ncasos; i++) {
                String[] linha = scanner.nextLine().split(" ");
                int opcao = Integer.parseInt(linha[0]);
                int numero = Integer.parseInt(linha[1]);

                if (opcao == 1) {
                    pilha.push(numero);
                    fila.enqueue(numero);
                    filaPrioridade.enqueue(numero);

                } else if (opcao == 2) {
                    if (numero == pilha.peek()) {
                        pilha.pop();
                        contadorPilha++;
                    }
                    if (numero == fila.front()) {
                        fila.dequeue();
                        contadorFila++;
                    }
                    if (numero == filaPrioridade.front()) {
                        filaPrioridade.dequeue();
                        contadorFilaPrioridade++;
                    }
                }

            }

            if (contadorPilha > contadorFilaPrioridade && contadorPilha > contadorFila) {
                System.out.println("stack");

            } else if (contadorFila > contadorPilha && contadorFila > contadorFilaPrioridade) {
                System.out.println("queue");

            } else if (contadorFilaPrioridade > contadorFila && contadorFilaPrioridade > contadorPilha) {
                System.out.println("priority queue");

            } else if (contadorFila == 0 && contadorPilha == 0 && contadorFilaPrioridade == 0) {
                System.out.println("impossible");

            } else {
                System.out.println("not sure");
            }
        }
    }
}
