package fila.prioridade;

public class FilaDPO { //Fila dinâmica de prioridade ordenada
    public No primeiro;
    public No ultimo;
    public int contador;

    public FilaDPO(){
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public void enqueue(Object dado, int prioridade) {
        No novo = new No(dado, prioridade);

        if(this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;

        } else if(novo.prioridade < primeiro.prioridade){
            novo.proximo = this.primeiro;
            this.primeiro.anterior = novo;
            this.primeiro = novo;

        } else if(novo.prioridade >= this.ultimo.prioridade) {
            this.ultimo.proximo = novo;
            novo.anterior = this.ultimo;
            this.ultimo = novo;

        }else {
            No aux = this.primeiro;
            while (aux != null && novo.prioridade >= aux.prioridade){
                aux = aux.proximo;
            }
            aux.anterior.proximo = novo;
            novo.anterior = aux.anterior;
            novo.proximo = aux;
            aux.anterior = novo;
        }
        this.contador++;
    }

    public void enqueue(Object dado) {
        enqueue(dado, 2);
    }

    public Object dequeue(){
        if(this.primeiro != null) {
            No item = this.primeiro;
            this.primeiro = this.primeiro.proximo;
            this.contador--;
            return item.dado;
        }
        return null;
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

    public static void main(String[] args) {
        FilaDPO filaDPO = new FilaDPO();

        filaDPO.enqueue(1, 0);
        filaDPO.enqueue(4, 1);
        filaDPO.enqueue(5, 2);
        filaDPO.enqueue(13, 3);
        filaDPO.enqueue(11, 4);
        filaDPO.enqueue(2, 5);

        filaDPO.show();
    }
}
