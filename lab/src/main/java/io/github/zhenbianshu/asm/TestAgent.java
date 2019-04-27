package io.github.zhenbianshu.asm;

import java.lang.instrument.Instrumentation;

/**
 * created by xiepengfei on 2018/11/10
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        inst.addTransformer(new TestTransformer(), true);
        try {
            inst.retransformClasses(TransformTarget.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
