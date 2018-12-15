package shut_down;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class ShutDownSignalHandler implements SignalHandler {

    @Override
    public void handle(Signal signal) {
        int signalNumber = signal.getNumber();
        System.out.println("we get the signal before shutdown, the signal number is "+signalNumber);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("add shutdown hook to handle resource")));
        System.exit(0);
    }
}
