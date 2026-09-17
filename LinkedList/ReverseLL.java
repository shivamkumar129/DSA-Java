package LinkedList;

import java.util.Scanner;

public class ReverseLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    // Iterative approach to reverse linked list
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.println("Enter number of Nodes:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }

        System.out.print("Original LinkedList: ");
        list.display();

        // Create object of ReverseLL
        ReverseLL obj = new ReverseLL();

        // Reverse and update head
        list.head = obj.reverse(list.head);

        System.out.print("Reversed LinkedList: ");
        list.display();

        sc.close();
    }
}