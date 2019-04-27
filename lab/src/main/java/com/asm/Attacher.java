package com.asm;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * created by xiepengfei on 2018/11/10
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {

        VirtualMachine vm = VirtualMachine.attach("4286");
        vm.loadAgent("/Users/pengfei29/IdeaProjects/logtest/target/logtest-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }
}
