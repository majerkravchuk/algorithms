package Fundamentals.Implementations;

import Fundamentals.Interfaces.IQueue;
import Fundamentals.Clients.QueueClient;

public class LinkedListQueue<Item> extends BaseLinked<Item> implements IQueue<Item> {
    private Node last;

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public static void main(String[] args) {
        new QueueClient(new LinkedListQueue<String>()).Run();
    }
}
