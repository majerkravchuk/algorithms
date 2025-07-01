package Fundamentals.Interfaces;

public interface IBag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}
