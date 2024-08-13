package week3;

public class LinkedList<T> {
    private int size = 0;
    private Node first;

    public int size() {
        return size;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node(value);
        } else {
            Node temp = this.first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
        }
        size++;
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = this.first;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = this.first;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (prev == null) {
            first = temp.next;
        } else {
            prev.next = temp.next;
        }

        size--;
        return temp.value;
    }

    public boolean contains(T element) {
        Node temp = this.first;
        while (temp != null) {
            if (temp.value.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private class Node {
        private final T value;
        public Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
