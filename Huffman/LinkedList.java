public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    public Node<T> createNode(T val) {
        return new Node<T>(val);
    }

    public void addFront(T val) {
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addRightAfterHead(T val) {
        if (head == null) {
            head = createNode(val);
        } else {
            Node<T> newNode = createNode(val);
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public boolean search(T val) {
        if (head == null)
            return false;
        Node<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0)
                return true;
            iterator = iterator.next;
        }
        return false;
    }

    public boolean searchRecursive(T val, Node<T> tempHead) {
        if (tempHead == null)
            return false;
        if (tempHead.value.compareTo(val) == 0)
            return true;
        else {
            return searchRecursive(val, tempHead.next);
        }
    }

    public boolean searchRecursive(T val) {
        return searchRecursive(val, head);
    }

    public void selectionSort() {
        if (head == null) {
            System.out.println("this list is empty");
        }
        Node<T> generalIterator = head;
        while (generalIterator != null) {
            Node<T> findMinIterator = generalIterator.next;
            Node<T> minVal = generalIterator;
            while (findMinIterator != null) {
                if (findMinIterator.value.compareTo(minVal.value) == 1) {
                    minVal = findMinIterator;
                }
                findMinIterator = findMinIterator.next;
            }
            T temp = generalIterator.value;
            generalIterator.value = minVal.value;
            minVal.value = temp;

            generalIterator = generalIterator.next;
        }
    }

    public void delete(T val) {
        if (search(val) == false) {
            System.out.println("the value does not exist");
            return;
        }
        if (head.value.compareTo(val) == 0) {
            head = head.next;
        }
        Node<T> iterator = head, prev = head;
        while (iterator.value.compareTo(val) != 0) {
            prev = iterator;
            iterator = iterator.next;
        }
        prev.next = iterator.next;
    }

    public HuffmanNode deleteFromFront() {
        if (head == null)
            return null;
        HuffmanNode temp = (HuffmanNode) head.value;
        head = head.next;
        return temp;
    }

    public int count() {
        int count = 0;
        Node<T> iterator = head;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    public void addToEnd(T val) {
        if (head == null)
            addFront(val);
        else {
            Node<T> iterator = head;
            while (iterator.next != null)
                iterator = iterator.next;
            iterator.next = createNode(val);

        }
    }

    public void sortByFrequency() {
        // Simply defines the iterator as the head of the list.
        Node<T> iterator = head;
        // Initially defines the next as null.
        Node<T> next = null;
        // Defines the temp for swapping.
        T temp;

        // This while loop iterates through the list and compares the values of the
        // nodes.
        while (iterator != null) {
            next = iterator.next;
            // What bubble sort does is that it compares the values of the nodes and swaps
            // them (...)
            // if the value of the node is greater than the next node.
            while (next != null) {
                // So if the value of the iterator is greater than the next, then swap them.
                if (iterator.value instanceof HuffmanNode letter1 && next.value instanceof HuffmanNode letter2) {
                    // If both values are instances of Letter, then cast them to Letter.
                    // If the overall grade of the first student is greater than the second student,
                    // then swap them.
                    if (letter1.compareTo(letter2) > 0) {
                        temp = iterator.value;
                        iterator.value = next.value;
                        next.value = temp;
                    }
                }
                // If not then just move on to the next node.
                next = next.next;
            }
            // Move on to the next node.
            iterator = iterator.next;
        }
    }

    public void display() {
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }

    public HuffmanTree createHuffmanTree() {
        sortByFrequency();
        while (count() > 1) {
            HuffmanNode left = deleteFromFront();
            HuffmanNode right = deleteFromFront();
            HuffmanNode newNode = new HuffmanNode(left.getFrequency() + right.getFrequency(), left, right);
            addFront((T) newNode);
            sortByFrequency();
        }

        return new HuffmanTree((HuffmanNode) head.value);
    }

}