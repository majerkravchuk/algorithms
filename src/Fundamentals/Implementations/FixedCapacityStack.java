package Fundamentals.Implementations;

import java.util.Iterator;
import Fundamentals.Interfaces.IStack;
import Fundamentals.Clients.StackClient;

public class FixedCapacityStack<Item> implements IStack<Item> {
    private Item[] stack;
    private int N;

    public FixedCapacityStack(int cap) {
        stack = (Item[]) new Object[cap];
    }

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void push(Item value) { stack[N++] = value; }

    public Item pop() { return stack[--N]; }

    public Iterator<Item> iterator() { return new ArrayIterator(); }

    private class ArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return stack[--i]; }
    }

    public static void main(String[] args) {
        new StackClient(new FixedCapacityStack<String>(10)).Run();
    }
}
