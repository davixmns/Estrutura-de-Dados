package fila.prioridade.heap;

public class HeapMaximo {
    private int[] data;
    private int counter;

    public HeapMaximo(int n) {
        this.data = new int[n];
        this.counter = 0;
    }

    private int getLeft(int i) {
        return (i * 2) + 1;
    }

    private int getRight(int i) {
        return (i * 2) + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int front() {
        if (this.counter == 0) {
            throw new RuntimeException("Heap vazio");
        }
        return data[0];
    }

    public void insert(int value) {
        if (this.counter == this.data.length) {
            throw new ArrayIndexOutOfBoundsException("Vetor lotado");
        }
        this.data[counter] = value;
        this.counter++;
        up(this.counter - 1);
    }

    private void up(int index) {
        if (index != 0) {
            int parentIndex = getParent(index);
            if (data[index] > data[parentIndex]) {
                int aux = data[parentIndex];
                data[parentIndex] = data[index];
                data[index] = aux;
                up(parentIndex);
            }
        }
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Heap vazio");
        }
        data[0] = data[counter - 1];
        counter--;
        if (counter > 0)
            down(0);
    }

    private void down(int index) {
        int leftIndex = getLeft(index); //1
        int rightIndex = getRight(index); //2
        int biggerIndex;

        if (rightIndex >= counter) {
            if (leftIndex >= counter)
                return;
            else
                biggerIndex = leftIndex;

        } else {
            if (data[leftIndex] >= data[rightIndex])
                biggerIndex = leftIndex;
            else
                biggerIndex = rightIndex;
        }

        if (data[biggerIndex] > data[index]) {
            int aux = data[biggerIndex];
            data[biggerIndex] = data[index];
            data[index] = aux;
            down(biggerIndex);
        }
    }

    public int size() {
        return this.counter;
    }

    public void show() {
        for (int i = 0; i < counter; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
