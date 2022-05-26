package arvore;

public class No {
    public No esquerdo;
    public No direito;
    public int dado;

    public No(int dado) {
        this.dado = dado;
        this.esquerdo = null;
        this.direito = null;
    }
}
