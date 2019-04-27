package io.github.zhenbianshu.common;

/**
 * @author zbs 2019/4/18
 */
public class GotoLabel {
    public static void main(String[] args) {
        test:
        for (int i=0;i<10;i++) {
            System.out.println(i);
            if (i == 5) {
                continue test;
            }
        }
    }
}
