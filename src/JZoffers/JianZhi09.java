package JZoffers;

import java.util.LinkedList;

public class JianZhi09 {
    public static void main(String[] args) {
        CQueue que = new CQueue();
        int temp = que.deleteHead();
        System.out.println(temp);
        que.appendTail(5);
        que.appendTail(-2);
        int temp1 = que.deleteHead();
        System.out.println(temp1);
        int temp2 = que.deleteHead();
        System.out.println(temp2);
    }

    static class CQueue {
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public CQueue(){
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            // 如果第二个栈为空
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.addLast(stack1.removeLast());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                int deleteItem = stack2.removeLast();
                return deleteItem;
            }
        }
    }
}
