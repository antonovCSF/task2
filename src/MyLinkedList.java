public class MyLinkedList {
    private int size = 0;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int element) {
        Node link = new Node(element);
        if (size == 0) {
            head = link;
            tail = link;
        } else {
            tail.next = link;
            tail = link;
        }
        size++;
    }

    public void addFirst(int value) {
        Node link = new Node(value);
        if (size == 0) {
            head = link;
            tail = link;
        } else {
            link.next = head;
            head = link;
        }
        size++;
    }

    public void set(int value, int index) {
        checkExeptions(index);
        if (index == 0) {
            addFirst(value);
        } else {
            Node element = head;
            for (int i = 0; i < index - 1; i++) {
                element = element.next;
            }
            Node a = new Node(value);
            a.next = element.next;
            element.next = a;
            size++;
        }
    }

    public void remove(int index) {
        checkExeptions(index);
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
        } else {
            Node element = head;
            for (int i = 0; i < index - 1; i++) {
                element = element.next;
            }
            element.next = element.next.next;
            if (index == size - 1) tail = element;
        }
        size--;
    }

    public int get(int index) {
        checkExeptions(index);
        Node element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.value;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    private void checkExeptions(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index can't be less than 0");
        if (index >= size) throw new IndexOutOfBoundsException("Index must be less than size");
    }

    public void removeEven(){
        while(head.value % 2  != 1){
            head = head.next;
            size--;
            if (head == null) return;
        }

        Node element = head;
        while (element.next != null){
            if (element.next.value % 2 == 0) {
                while (true) {
                    if (element.next == null) {
                        tail = element;
                        break;
                    }

                    if (element.next.value % 2 == 1) {
                        element = element.next;
                        break;
                    }

                    element.next = element.next.next;
                    size--;
                }
            } else element = element.next;
        }
    }
}
