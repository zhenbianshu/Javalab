package io.github.zhenbianshu.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author zbs 2019/3/2
 */
public class TomcatServer {
    public static void main(String[] args) {
        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.startTomcat();
    }


    public void startTomcat() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(32222);
        try {
            tomcat.start();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }


        Thread awaitThread = new Thread("container-tomcat") {
            @Override
            public void run() {
                tomcat.getServer().await();
            }
        };
        awaitThread.setContextClassLoader(getClass().getClassLoader());
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
