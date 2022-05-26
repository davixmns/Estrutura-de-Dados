package fila;

public class FilaD { //Fila dinâmica
    private No primeiro;
    private No ultimo;
    private int contador;

    public FilaD() {
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

    public void dequeue() {
        this.primeiro = this.primeiro.proximo;
        this.contador--;
    }

    public Object front() {
        return this.primeiro.dado;
    }

    public int size() {
        return this.contador;
    }

    public boolean isEmpty() {
        return this.contador == 0;
    }

    public void show() {
        No aux = this.primeiro;
        while (aux != null) {
            System.out.print(aux.dado + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
