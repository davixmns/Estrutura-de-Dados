package fila.prioridade;

public class No {
    public No proximo;
    public No anterior;
    public Object dado;
    public int prioridade;

    public No(Object dado, int prioridade){
        this.dado = dado;
        this.prioridade = prioridade;
        this.proximo = null;
        this.anterior = null;
    }
}
