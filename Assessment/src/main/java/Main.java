// src/main/java/Main.java
public class Main {
    public static void main(String[] args) {
        // Create vehicles
        Motorcycle m = new Motorcycle();
        Car c = new Car();
        Bus b = new Bus();

        // Use doubly linked list
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(m);
        dll.insert(c);
        dll.insert(b);
        dll.printList();

        // Use binary tree
        BinaryTree bt = new BinaryTree();
        bt.insert(m);
        bt.insert(c);
        bt.insert(b);
        Vehicle found = bt.search("Car");
        if (found != null) {
            System.out.println("Found: " + found.type);
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
