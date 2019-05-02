package agent;



import java.lang.instrument.Instrumentation;


//java -javaagent:agent.jar MainRun

/**
 * link: https://juejin.im/post/5cc01e83f265da0373718923
 */
public class AgentApp {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("==============enter premain==============");
        System.out.println(agentOps);
        inst.addTransformer(new Agent());
    }

    public static void agentmain(String agentOps, Instrumentation inst) {
        System.out.println("==============enter agentmain==============");
    }

}
