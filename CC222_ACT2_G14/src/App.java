import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Node {
    int number;
    Node next;

    Node(int d) {
        this.number = d;  
        this.next = null;
    }
}

class Operations {
    private List<Integer> arrayList = new ArrayList<>();
    private Node head = null;

    public void insertArray(int value) {
        arrayList.add(value);
        System.out.println("Array after insertion: " + arrayList);
    }

    public void insertLinkedList(int value, boolean atBeginning) {
        Node newNode = new Node(value);
        if (atBeginning) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            if (temp != null) {
                temp.next = newNode; 
            }
        }
        printLinkedList();
    }

    private void printLinkedList() {
        System.out.println("Linked List after insertion: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class App {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        Operations op = new Operations();

        while (true) {
            System.out.println("Enter a number: ");
            int num = SC.nextInt();

            System.out.println("Choose Operation:");
            System.out.println("1. Insert into Array");
            System.out.println("2. Insert into Linked List");
            int operation = SC.nextInt();

            if (operation == 1) {
                op.insertArray(num);
            } else if (operation == 2) {
                System.out.println("Insert into Linked List:");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at End");

                int choice = SC.nextInt();

                op.insertLinkedList(num, choice == 1);
            } else {
                System.out.println("Invalid choice! Try again.");
            }

            System.out.println("\nOptions:");
            System.out.println("1. Enter new value");
            System.out.println("2. End ");
            int choose = SC.nextInt();

            if (choose == 2) {
                break;
            }
        }

        SC.close();  
    }
}
