package io.github.zhenbianshu.thread;

/**
 * @author zbs 2019/4/20
 */
public class OOM {
    public static void main(String[] args) {
        for (int i = 1; i < 2000; i++) {
            Thread t = new Thread(OOM::keep);
            System.out.println(i);
            t.start();
        }
    }


    public static void keep() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
