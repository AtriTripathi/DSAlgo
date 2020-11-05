public class DoublyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
        public Node(T data) {
            this.data = data;
        }
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedList() {
        headNode = null;
        tailNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            size++;
            return;
        }

        newNode.nextNode = headNode;
        headNode.prevNode = newNode;
        headNode = newNode;
        size++;
    }

    public void insertAtTail(T data) {
        Node newNode = new Node(data);
        if(tailNode == null) {
            headNode = newNode;
            tailNode = newNode;
            size++;
            return;
        }

        newNode.prevNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public Node deleteAtHead() {
        if(headNode == null || headNode.nextNode == null)
            return null;
        headNode.nextNode.prevNode = null;
        headNode = headNode.nextNode;
        return headNode;
    }

    public Node deleteAtTail() {
        if(headNode == null || headNode.nextNode == null)
            return null;
        tailNode.prevNode.nextNode = null;
        return headNode;
    }



    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtHead(1);
        dll.insertAtTail(2);
        dll.insertAtHead(3);
        dll.insertAtTail(4);
        dll.printList();
        dll.deleteAtTail();
        dll.printList();
    }
}
