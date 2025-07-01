package Fundamentals.Implementations;

import java.util.Iterator;
import Fundamentals.Interfaces.IStack;
import Fundamentals.Clients.StackClient;

public class FixedCapacityStackOfStrings implements IStack<String> {
    private String[] stack;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        stack = new String[cap];
    }

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void push(String value) { stack[N++] = value; }

    public String pop() { return stack[--N]; }

    public Iterator<String> iterator() { return new ArrayIterator(); }

    private class ArrayIterator implements Iterator<String> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public String next() { return stack[--i]; }
    }

    public static void main(String[] args) {
        new StackClient(new FixedCapacityStackOfStrings(10)).Run();
    }
}
