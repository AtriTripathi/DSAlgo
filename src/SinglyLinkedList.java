public class SinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    public void insertAtTail(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node currentNode = headNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = newNode;
        size++;
    }

    public void insertAfter(T data, T previous) {
        Node newNode = new Node();
        newNode.data = data;

        Node currentNode = headNode;
        while(currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }

        if(currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public void deleteAtHead() {
        if (isEmpty())
            return;

        headNode = headNode.nextNode;
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty())
            return;

        //For only one element
        if(headNode.nextNode == null) {
            deleteAtHead();
            return;
        }

        Node currentNode = headNode;
        Node previousNode = null;

        while(currentNode.nextNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        if (previousNode != null) {
            previousNode.nextNode = null;
            size--;
        }
    }

    public void deleteByValue(T data) {
        if (isEmpty())
            return;

        if(headNode.data.equals(data)) {
            deleteAtHead();
            return;
        }

        Node currentNode = headNode;
        Node previousNode = null;

        while (currentNode != null) {
            if(currentNode.data.equals(data)) {
                previousNode.nextNode = currentNode.nextNode;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
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

    //Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return true; //value found

            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.printList();
        sll.insertAtHead(1);
        sll.insertAtTail(2);
        sll.insertAtTail(3);
        sll.printList();
        sll.deleteAtTail();
        sll.printList();
    }
}














