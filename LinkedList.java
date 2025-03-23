public class LinkedList {

    class Node {

        int data;

        Node next;



        Node(int data) {

            this.data = data;

            this.next = null;

        }

    }



    private Node head;



    public LinkedList() {

        head = null;

    }



    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;

    }



    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;

            return;

        }

        Node current = head;

        while (current.next != null) {

            current = current.next;

        }

        current.next = newNode;

    }



    public void insertAtPosition(int data, int position) {

        if (position < 0) {

            System.out.println("Invalid position");

            return;

        }

        Node newNode = new Node(data);

        if (position == 0) {

            newNode.next = head;

            head = newNode;

            return;

        }

        Node current = head;

        for (int I = 0; I < position - 1 && current != null; I++) {

            current = current.next;

        }

        if (current == null) {

            System.out.println("Position out of bounds");

            return;

        }

        newNode.next = current.next;

        current.next = newNode;

    }



    public void deleteFromBeginning() {

        if (head == null) {

            System.out.println("List is empty");

            return;

        }

        head = head.next;

    }



    public void deleteFromEnd() {

        if (head == null) {

            System.out.println("List is empty");

            return;

        }

        if (head.next == null) {

            head = null;

            return;

        }

        Node current = head;

        while (current.next.next != null) {

            current = current.next;

        }

        current.next = null;

    }



    public Boolean search(int key) {

        Node current = head;

        while (current != null) {

            if (current.data == key) {

                return true;

            }

            current = current.next;

        }

        return false;

    }



    public void printList() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;

        }

        System.out.println("null");

    }



    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(1);

        list.insertAtBeginning(2);

        list.insertAtEnd(3);

        list.insertAtPosition(4, 2);

        System.out.println("Original list:");

        list.printList();

        list.deleteFromBeginning();

        System.out.println("After deleting from beginning:");

        list.printList();

        list.deleteFromEnd();

        System.out.println("After deleting from end:");

        list.printList();

        System.out.println("Search for 1: " + list.search(1));

        System.out.println("Search for 5: " + list.search(5));

    }

}