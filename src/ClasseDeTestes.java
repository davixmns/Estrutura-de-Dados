public class ClasseDeTestes {
    static class No {
        public No esquerdo;
        public No direito;
        public int dado;

        public No(int dado) {
            this.dado = dado;
            this.direito = null;
            this.esquerdo = null;
        }
    }

    static class Arvore {
        private No raiz;

        public void insert(int dado) {
            if (raiz == null)
                this.raiz = new No(dado);
            else
                insert(dado, this.raiz);
        }

        private void insert(int dado, No raiz) {
            if (dado < raiz.dado) {
                if (raiz.esquerdo == null)
                    raiz.esquerdo = new No(dado);
                else
                    insert(dado, raiz.esquerdo);

            } else if (dado > raiz.dado) {
                if (raiz.direito == null)
                    raiz.direito = new No(dado);
                else
                    insert(dado, raiz.direito);

            }
        }

        public void show(int escolha) {
            if (this.raiz != null) {
                switch (escolha) {
                    case 1 -> preOrdem(this.raiz);
                    case 2 -> emOrdem(this.raiz);
                    case 3 -> posOrdem(this.raiz);
                }
                System.out.println();
            }
        }

        private void preOrdem(No raiz) {
            System.out.print(raiz.dado + " ");
            if (raiz.esquerdo != null)
                preOrdem(raiz.esquerdo);
            if (raiz.direito != null)
                preOrdem(raiz.direito);
        }

        private void emOrdem(No raiz) {
            if (raiz.esquerdo != null)
                emOrdem(raiz.esquerdo);
            System.out.print(raiz.dado + " ");
            if (raiz.direito != null) {
                emOrdem(raiz.direito);
            }
        }

        private void posOrdem(No raiz) {
            if (raiz.esquerdo != null)
                posOrdem(raiz.esquerdo);
            if (raiz.direito != null) {
                posOrdem(raiz.direito);
            }
            System.out.print(raiz.dado + " ");
        }

    }

    public static void main(String[] args) {
        Arvore a = new Arvore();

        a.insert(5);
        a.insert(3);
        a.insert(9);
        a.insert(10);
        a.insert(8);
        a.insert(1);
        a.insert(7);
        a.insert(2);

        a.show(1);

    }
}
