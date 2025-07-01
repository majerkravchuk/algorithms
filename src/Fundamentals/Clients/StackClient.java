package Fundamentals.Clients;

import edu.princeton.cs.algs4.StdOut;
import Fundamentals.Interfaces.IStack;

public class StackClient {
    private IStack<String> stack;

    public StackClient(IStack<String> stack) {
        this.stack = stack;
    }

    public void Run() {
        stack.push("!\n");
        stack.push("fools");
        stack.pop();
        stack.push("world");
        stack.push(", ");
        stack.push("hello");

        for (String string : stack) {
            StdOut.print(string);
        }
    }
}
