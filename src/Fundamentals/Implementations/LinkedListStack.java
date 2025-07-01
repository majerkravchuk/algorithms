package Fundamentals.Implementations;

import Fundamentals.Interfaces.IStack;
import Fundamentals.Clients.StackClient;

public class LinkedListStack<Item> extends BaseLinked<Item> implements IStack<Item> {
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        new StackClient(new LinkedListStack<String>()).Run();
    }
}
