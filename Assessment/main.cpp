#include <iostream>
#include <string>

class Vehicle {
public:
    virtual void park() = 0;
    virtual ~Vehicle() {}
    std::string type;
};

class Motorcycle : public Vehicle {
public:
    Motorcycle() { type = "Motorcycle"; }
    void park() override {
        std::cout << "Parking a motorcycle." << std::endl;
    }
};

class Car : public Vehicle {
public:
    Car() { type = "Car"; }
    void park() override {
        std::cout << "Parking a car." << std::endl;
    }
};

class Bus : public Vehicle {
public:
    Bus() { type = "Bus"; }
    void park() override {
        std::cout << "Parking a bus." << std::endl;
    }
};

struct Node {
    Vehicle* vehicle;
    Node* next;
    Node* prev;
    Node(Vehicle* v) : vehicle(v), next(nullptr), prev(nullptr) {}
};

class DoublyLinkedList {
private:
    Node* head;
    Node* tail;
public:
    DoublyLinkedList() : head(nullptr), tail(nullptr) {}
    void insert(Vehicle* vehicle) {
        Node* newNode = new Node(vehicle);
        if (!head) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
    }
    void remove(Vehicle* vehicle) {
        Node* current = head;
        while (current) {
            if (current->vehicle == vehicle) {
                if (current->prev) current->prev->next = current->next;
                if (current->next) current->next->prev = current->prev; 
                if (current == head) head = current->next;
                if (current == tail) tail = current->prev;
                delete current;
                break;
            }
            current = current->next;
        }
    }
    void printList() {
        Node* current = head;
        while (current) {
            std::cout << current->vehicle->type << " ";
            current = current->next;
        }
        std::cout << std::endl;
    }
};

struct TreeNode {
    Vehicle* vehicle;
    TreeNode* left;
    TreeNode* right;
    TreeNode(Vehicle* v) : vehicle(v), left(nullptr), right(nullptr) {}
};

class BinaryTree {
private:
    TreeNode* root;
    TreeNode* insert(TreeNode* node, Vehicle* vehicle) {
        if (!node) return new TreeNode(vehicle);
        if (vehicle->type < node->vehicle->type) {
            node->left = insert(node->left, vehicle);
        } else {
            node->right = insert(node->right, vehicle);
        }
        return node;
    }
    TreeNode* search(TreeNode* node, const std::string& type) {
        if (!node || node->vehicle->type == type) return node;
        if (type < node->vehicle->type) return search(node->left, type);
        return search(node->right, type);
    }
public:
    BinaryTree() : root(nullptr) {}
    void insert(Vehicle* vehicle) {
        root = insert(root, vehicle);
    }
    Vehicle* search(const std::string& type) {
        TreeNode* result = search(root, type);
        return result ? result->vehicle : nullptr;
    }
};

int main() {
    // Create vehicles
    Motorcycle m;
    Car c;
    Bus b;

    // Use doubly linked list
    DoublyLinkedList dll;
    dll.insert(&m);
    dll.insert(&c);
    dll.insert(&b);
    dll.printList();

    // Use binary tree
    BinaryTree bt;
    bt.insert(&m);
    bt.insert(&c);
    bt.insert(&b);
    Vehicle* found = bt.search("Car");
    if (found) {
        std::cout << "Found: " << found->type << std::endl;
    } else {
        std::cout << "Vehicle not found." << std::endl;
    }

    return 0;
}
