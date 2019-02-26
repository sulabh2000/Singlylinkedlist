package main;

public class Node {
    private int data;
    private Node next;

    public Node() {

    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    private Node head = null;
    int size = 0;

    public static void main(String[] args) {
        Node linkedList = new Node();
        System.out.println(linkedList);

//        linkedList.insertHead(42);
//        linkedList.insertHead(66);

        linkedList.insert(42);
        linkedList.insert(66);

        System.out.println(linkedList);

    }

    @Override
    public String toString() {
        StringBuilder response;
        response = new StringBuilder();

        response.append("[");
        Node temp = this.head;
        while (temp != null) {
            response.append(temp.getData());

            if (temp.next != null) {
                response.append(" ==> ;");
            }
            temp = temp.next;
        }

        response.append("]");
        return response.toString();

    }

    private void insertHead(int data) {
        Node newNode = new Node(data, this.head);
        this.head = newNode;
        size++;
    }

    private void insertAfter(int data, Node node) {
        /*Node newNode = new Node(data, node.next);
        node.next= newNode;*/

        node.next = new Node(data, node.next);
        size++;
    }

    public void insert(int data) {
        if (head == null) {
            insertHead(data);
        } else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }
            insertAfter(data, temp);
        }
    }
}
