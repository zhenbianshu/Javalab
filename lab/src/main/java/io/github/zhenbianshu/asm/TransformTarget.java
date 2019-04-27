package io.github.zhenbianshu.asm;

/**
 * created by xiepengfei on 2018/11/10
 */
public class TransformTarget {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(3000L);
            } catch (Exception e) {
                break;
            }
            printSomething();
        }
    }

    public static void printSomething() {
        System.out.println("hello");
    }

}








