package by.tms.linkedlist;

public class LinkList implements IList {
    private Node head;
    private Node last;
    private int size;

    private class Node {
        private Node prev;
        private Object data;
        private Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(temp, data, null);
        this.last = newNode;
        if (head == null) {
            this.head = newNode;
        } else {
            temp.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean addAll(IList collection) {
        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
        return true;
    }

    public boolean contains(Object data) {
        if (data == null) {
            boolean flag = false;
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    return flag;
                }
            }
        } else {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data.equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(Object data) {
        if (data == null) {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    unLike(temp);
                    return true;
                }
            }
        } else {
            for (Node temp = head; temp != null; temp = temp.next) {
                if (temp.data.equals(data)) {
                    unLike(temp);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        Object object = get(index);
        remove(object);
        return true;
    }

    private Object unLike(Node x) {
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        this.size--;
        return elementData;
    }

    public Object set(int index, Object newData) {
        if (!isLinkIndex(index)) {
            return null;
        }
        Node node = node(index);
        Object element = node.data;
        node.data = newData;
        return element;
    }


    public Object get(int index) {
        if (!isLinkIndex(index)) {
            return null;
        }
        Node node = node(index);
        return node.data;
    }

    @Override
    public Object getLast() {
        return get(this.size - 1);
    }

    @Override
    public Object getFirst() {
        return get(0);
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        Node temp = this.last;
        for (int i = size - 1; i > index; i--) {
            temp = temp.prev;
        }
        return temp;
    }

    private boolean isLinkIndex(int index) {
        return index >= 0 && index < size;
    }

    public void clear() {
        for (Node temp = head; temp != null; ) {
            temp.data = null;
            Node node = temp.next;
            temp = temp.next = temp.prev = null;
            temp = node;
            this.size--;
        }
    }

    public int size() {
        return this.size;
    }
}