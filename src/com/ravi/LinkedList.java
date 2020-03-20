package com.ravi;

public class LinkedList<X> {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(X value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public X remove() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }

        X var = first.value;
        first = first.next;
        size--;
        return var;
    }

    public void insertAt(X item, int position) {
        if (size < position) {
            throw new IllegalArgumentException("Position outside range");
        }

        Node current = first;
        int i = 1;
        while (i < position && current != null) {
            current = current.next;
            i++;
        }

        Node node = new Node(item);
        Node next = current.getNext();
        current.next = node;
        node.next = next;
        size++;
    }

    public boolean contains(X item) {
        Node current = first;
        while (current != null) {
            if (current.value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    private class Node {
        private Node next;
        private X value;

        public Node(X value) {
            this.value = value;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public X getValue() {
            return value;
        }

        public void setValue(X value) {
            this.value = value;
        }
    }
}
