package pilha;

public class PilhaD { //Pilha dinâmica
    private No topo;
    private int contador;

    public PilhaD() {
        this.topo = null;
        this.contador = 0;
    }

    public void push(Object dado) {
        No novo = new No(dado);
        novo.abaixo = this.topo;
        this.topo = novo;
        this.contador++;
    }

    public Object pop() {
        if (this.topo != null) {
            No item = this.topo;
            this.topo = this.topo.abaixo;
            this.contador--;
            return item.dado;
        }
        return null;
    }

    public Object peek() {
        return topo.dado;
    }

    public int size() {
        return this.contador;
    }

    public boolean isEmpty() {
        return this.contador == 0;
    }

    public void show() {
        No aux = this.topo;
        while (aux != null) {
            System.out.print(aux.dado + " ");
            aux = aux.abaixo;
        }
        System.out.println();
    }

}
