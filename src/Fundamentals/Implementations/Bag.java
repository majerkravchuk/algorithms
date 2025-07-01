package Fundamentals.Implementations;

import Fundamentals.Clients.BagClient;
import Fundamentals.Interfaces.IBag;

public class Bag<Item> extends BaseLinked<Item> implements IBag<Item> {
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = first;
        first.next = oldFirst;
    }

    public static void main(String[] args) {
        new BagClient(new Bag<String>()).Run();
    }
}
