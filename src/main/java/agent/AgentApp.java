package agent;



import java.lang.instrument.Instrumentation;


//java -javaagent:agent.jar MainRun
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
