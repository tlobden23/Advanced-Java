package edu.bhcc;

public class LinkedList {
    private Node head;

    // O(n) time complexity
    public void insertAtEnd(int d) {
        Node newNode = new Node(d);

        Node temp = head;

        if (temp == null) {
            head = newNode;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }
    }

    // O(1) time complexity
    public void insertAtBeginning(int d) {
        Node newNode = new Node(d);

        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    // O(1) time complexity
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("There is nothing to delete. The linked list is empty");
        } else {
            Node temp = head;
            head = temp.getNext();
            temp = null;
        }
    }

    // O(n) time complexity
    public void deleteAtEnd(){
        Node temp = head;

        if (temp == null) {
            System.out.println("There is nothing to delete. The linked list is empty.");
        } else if (temp.getNext() == null) {
            head = null;
        } else {
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
    }

    // O(n) time complexity
    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
