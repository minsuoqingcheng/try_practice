package grade4.priority_queue_test;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(9);       //[9,10,20]
        priorityQueue.poll();
        System.out.println(priorityQueue);

    }

}
