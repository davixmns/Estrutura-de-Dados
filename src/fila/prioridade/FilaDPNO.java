package fila.prioridade;

public class FilaDPNO { //Fila dinâmica de prioridade não ordenada
    public No primeiro;
    public No ultimo;
    public int contador;

    public FilaDPNO() {
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public void enqueue(Object dado, int prioridade) {
        No novo = new No(dado, prioridade);
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

    public void enqueue(Object dado) {
        enqueue(dado, 2);
    }

    public void dequeue() {
        for (int i = 0; i < 3; i++) {
            No aux = this.primeiro;

            while (aux != null && aux.prioridade != i) {
                aux = aux.proximo;
            }

            if (aux != null) {
                if (aux == this.primeiro) {
                    this.primeiro = this.primeiro.proximo;
                } else if(aux == this.ultimo){
                    this.ultimo = this.ultimo.anterior;
                } else {
                    aux.anterior.proximo = aux.proximo;
                    aux.proximo.anterior = aux.anterior;
                }
                this.contador--;
                break;
            }
        }
    }

    public Object front(){
        return this.primeiro.dado;
    }

    public void clear(){
        this.contador = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public int size(){
        return this.contador;
    }

    public boolean isEmpty(){
        return this.contador == 0;
    }

    public void show(){
        No aux = this.primeiro;
        while (aux != null){
            System.out.print(aux.dado + "-" + aux.prioridade + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

}
