package Fundamentals.Implementations;

import java.util.Iterator;
import Fundamentals.Interfaces.IStack;
import Fundamentals.Clients.StackClient;

public class ResizingArrayStack<Item> implements IStack<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void push(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
            return item;
    }

    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
    }

    public static void main(String[] args) {
        new StackClient(new ResizingArrayStack<String>()).Run();
    }
}
