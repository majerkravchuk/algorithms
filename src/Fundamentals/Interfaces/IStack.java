package Fundamentals.Interfaces;

public interface IStack<Item> extends Iterable<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
