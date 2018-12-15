package shut_down;

import sun.misc.Signal;

import java.lang.management.ManagementFactory;

public class Test {

    public static void main(String[] args) {
        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        //register signal handler
        ShutDownSignalHandler handler = new ShutDownSignalHandler();
        Signal.handle(new Signal("TERM"), handler);
        // already used by VM or OS: SIGKILL
        //Signal.handle(new Signal("KILL"), handler);
        while (true) {

        }

    }

}
