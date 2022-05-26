package lista;

public class ListaD { //Lista de Objetos dinâmica duplamente encadeada não circular
    public No primeiro;
    public No ultimo;
    public int contador;

    public ListaD() {
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public void add(Object dado) {
        No novo = new No(dado);

        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;

        } else {
            novo.anterior = this.ultimo;
            this.ultimo.proximo = novo;
            this.ultimo = novo;
        }

        this.contador++;
    }

    public void add(int indice, Object dado) throws NullPointerException {
        if (indice > contador) {
            throw new NullPointerException("Índice inexistente na lista");
        }

        No novo = new No(dado);

        if (indice == 0) { //primeiro elemento
            this.primeiro.anterior = novo;
            novo.proximo = this.primeiro;
            this.primeiro = novo;

        } else if (indice == contador) { //ultimo elemento
            this.ultimo.proximo = novo;
            novo.anterior = ultimo;
            this.ultimo = novo;

        } else { //elemento intermediário
            No aux = this.primeiro;
            for (int i = 0; i < indice; i++) {
                aux = aux.proximo;
            }
            aux.anterior.proximo = novo;
            novo.proximo = aux;
            novo.anterior = aux.anterior;
            aux.anterior = novo;
        }

        this.contador++;
    }

    public void addInOrder(Object dado) {
        No novo = new No(dado);

        if(this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            if(novo.dado.toString().compareTo(this.primeiro.dado.toString()) <= 0){
                this.primeiro.anterior = novo;
                novo.proximo = this.primeiro;
                this.primeiro = novo;

            } else if(novo.dado.toString().compareTo(this.ultimo.dado.toString()) >= 0){
                this.ultimo.proximo = novo;
                novo.anterior = this.ultimo;
                this.ultimo = novo;

            } else {
                No aux = this.primeiro;
                while (aux != null && novo.dado.toString().compareTo(aux.dado.toString()) >= 0){
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

    public void remove(int indice) {
        if (indice == 0) {
            this.primeiro = primeiro.proximo;

        } else if (indice == contador) {
            this.ultimo = this.ultimo.anterior;

        } else {
            No aux = this.primeiro;
            for (int i = 0; i < indice; i++) {
                aux = aux.proximo;
            }
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }
        this.contador--;
    }

    public void remove(Object dado) {
        int indice = indexOf(dado);
        remove(indice);
        this.contador--;
    }

    public Object get(int indice) {
        No aux = this.primeiro;
        for (int i = 0; i < indice; i++) {
            aux = aux.proximo;
        }
        return aux.dado;
    }

    public int indexOf(Object dado) {
        No aux = this.primeiro;
        int c = 0;
        while (aux != null) {
            if (aux.dado.equals(dado)) {
                return c;
            }
            aux = aux.proximo;
            c++;
        }
        return -1;
    }

    public boolean contains(Object dado) {
        No aux = this.primeiro;
        while (aux != null) {
            if (aux.dado.equals(dado)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
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

    public void clear() {
        this.primeiro = null;
        this.ultimo = null;
        this.contador = 0;
    }

    public static void main(String[] args) {
        ListaD l = new ListaD();

        l.addInOrder(4);
        l.show();
        l.addInOrder(3);
        l.show();
        l.show();
        l.addInOrder(8);
        l.show();
        l.addInOrder(7);
        l.show();
        l.addInOrder(1);
        l.show();
        l.addInOrder(10);
        l.show();
        l.addInOrder(100);
        l.show();
    }

}
