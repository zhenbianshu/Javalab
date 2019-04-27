package com.thread;

/**
 * @author zbs 2019/4/20
 */

public class StackOOM {
    public static void main(String[] args) {
        recurise(1);
    }

    private static int recurise(int i) {
        return recurise(i++);
    }
}
