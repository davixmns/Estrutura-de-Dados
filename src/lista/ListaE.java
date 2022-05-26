package lista;

public class ListaE { //Lista estática de objetos
    private int[] v = new int[30];
    private int contador = 0;

    public void add(int dado) {
        v[contador] = dado;
        contador++;
    }

    public void add(int indice, int dado) {
        for (int i = contador; i > indice; i--) {
            v[i] = v[i - 1];
        }
        v[indice] = dado;
        this.contador++;
    }

    public void remove(int indice) {
        for (int i = indice; i < this.contador - 1; i++) {
            v[i] = v[i + 1];
        }

        this.contador--;
    }

    public int get(int i) {
        return v[i];
    }

    public boolean contains(int n) {
        for (int j : v) {
            if (j == n) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return contador;
    }

    public void show() {
        for (int i = 0; i < size(); i++) {
            System.out.print(v[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListaE le = new ListaE();

    }
}