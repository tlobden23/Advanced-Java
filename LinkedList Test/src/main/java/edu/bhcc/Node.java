package edu.bhcc;

public class Node {
    private int data;
    private Node next;

    public Node(int d) {
        this.data = d;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
