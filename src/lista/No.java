package lista;

public class No {
    public Object dado;
    public No proximo;
    public No anterior;

    public No(Object dado){
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}
