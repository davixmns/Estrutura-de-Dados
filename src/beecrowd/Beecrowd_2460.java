package beecrowd;

import java.util.Scanner;

public class Beecrowd_2460 {
    public static class Node {
        private int identifier;
        private Node next;
        private Node previous;

        public Node(int identifier) {
            this.identifier = identifier;
            this.next = null;
            this.previous = null;
        }
    }

    public static class Queue {
        private Node first;
        private Node last;
        private int counter;

        public Queue() {
            this.first = null;
            this.last = null;
            this.counter = 0;
        }

        public void enqueue(int identifier) {
            Node newer = new Node(identifier);
            if (this.first == null) {
                this.first = newer;
                this.last = newer;
            } else {
                this.last.next = newer;
                newer.previous = this.last;
                this.last = newer;
            }
            this.counter++;
        }

        public void dequeue() {
            if (this.first != null)
                this.first = first.next;
            this.counter--;
        }

        public void leave(int identifier) {
            if (this.first.identifier == identifier) {
                dequeue();
            } else if (this.last.identifier == identifier) {
                this.last = this.last.previous;
                this.last.next = null;
            } else {
                Node aux = this.first;
                while (aux != null && aux.identifier != identifier) {
                    aux = aux.next;
                }
                aux.next.previous = aux.previous;
                aux.previous.next = aux.next;
            }
            this.counter--;
        }

        public void show() {
            Node aux = this.first;
            while (aux != null) {
                if (aux.identifier == this.last.identifier) {
                    System.out.print(aux.identifier);
                    break;
                }
                System.out.print(aux.identifier + " ");
                aux = aux.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        int nPessoas = scanner.nextInt();
        scanner.nextLine();
        String[] pessoasNaFila = scanner.nextLine().split(" ");

        for (String pessoa : pessoasNaFila) {
            queue.enqueue(Integer.parseInt(pessoa));
        }

        int nDesistencias = scanner.nextInt();
        scanner.nextLine();
        String[] desistencias = scanner.nextLine().split(" ");

        for (String desistencia : desistencias) {
            queue.leave(Integer.parseInt(desistencia));
        }

        queue.show();
    }
}
