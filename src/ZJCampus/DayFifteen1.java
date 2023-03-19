package ZJCampus;

import java.util.LinkedList;

public class DayFifteen1 {
    public static void main(String[] args) {

    }
}
class MyQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.addLast(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
        }
        int deleteItem = stack2.removeLast();
        return deleteItem;
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
        }
        int peekItem = stack2.peekLast();
        return peekItem;
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
