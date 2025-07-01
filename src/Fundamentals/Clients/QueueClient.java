package Fundamentals.Clients;

import edu.princeton.cs.algs4.StdOut;
import Fundamentals.Interfaces.IQueue;

public class QueueClient {
    private IQueue<String> queue;

    public QueueClient(IQueue<String> queue) {
        this.queue = queue;
    }

    public void Run() {
        queue.enqueue("blah");
        queue.enqueue("hello");
        queue.enqueue(", ");
        queue.enqueue("world");
        queue.enqueue("!\n");

        queue.dequeue();

        for (String string : queue) {
            StdOut.print(string);
        }
    }
}
