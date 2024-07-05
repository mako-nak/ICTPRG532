// src/main/java/DoublyLinkedList.java
public class DoublyLinkedList {
    private class Node {
        Vehicle vehicle;
        Node next;
        Node prev;
        Node(Vehicle v) {
            vehicle = v;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(Vehicle vehicle) {
        Node newNode = new Node(vehicle);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(Vehicle vehicle) {
        Node current = head;
        while (current != null) {
            if (current.vehicle == vehicle) {
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                if (current == head) head = current.next;
                if (current == tail) tail = current.prev;
                break;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.vehicle.type + " ");
            current = current.next;
        }
        System.out.println();
    }
}
