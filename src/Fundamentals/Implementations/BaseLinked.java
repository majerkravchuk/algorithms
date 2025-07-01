package Fundamentals.Implementations;

import java.util.Iterator;

public class BaseLinked<Item> {
    protected class Node {
        Item item;
        Node next;
    }

    protected Node first;
    protected int N = 0;

    public int size() { return N; }
    public boolean isEmpty() { return first == null; }

    public Iterator<Item> iterator() { return new ListIterator(); }

    protected class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
