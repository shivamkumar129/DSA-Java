package LinkedList;
 import java.util.Scanner;

public class MiddleOfLL {

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

        // Approach 1: Iterative
        Node findMiddleIterative() {
            int count = 0;
            Node temp = head;

            while (temp != null) {
                count++;
                temp = temp.next;
            }

            temp = head;

            for (int i = 0; i < count / 2; i++) {
                temp = temp.next;
            }

            return temp;
        }

        // Approach 2: Slow and Fast Pointer
        Node findMiddleSlowFast() {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insert(data);
        }

        System.out.println("Linked List:");
        list.display();

        Node middle1 = list.findMiddleIterative();
        System.out.println("Middle using Iterative: " + middle1.data);

        Node middle2 = list.findMiddleSlowFast();
        System.out.println("Middle using Slow-Fast: " + middle2.data);

        sc.close();
    }
}
