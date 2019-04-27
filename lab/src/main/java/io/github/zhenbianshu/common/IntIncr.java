package io.github.zhenbianshu.common;

import java.util.Arrays;

/**
 * created by xiepengfei on 2018/12/12
 */
public class IntIncr {
    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "bb", "cc"};
        String reduced = Arrays.stream(arr).reduce("ss", (a, b) -> a + b);
        System.out.println(reduced); // ssaabbcc
    }
}
