package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCommunication {

    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

    private static void doTaskWithResultInWorker() {
        Callable<Integer> callable = () -> {
            System.out.println("Task starts");
            Thread.sleep(1000);
            int result = 0;
            for (int i=0; i<=100; i++) {
                result += i;
            }
            System.out.println("Task finished and return result");
            return result;
        };
        FutureTask futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}