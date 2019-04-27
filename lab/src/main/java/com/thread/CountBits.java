package com.thread;

/**
 * @author zbs 2019/4/18
 */
public class CountBits {
    public static void main(String[] args) {
        int i = 29;
        System.out.println(Integer.toBinaryString(-1 << i));
        System.out.println(Integer.toBinaryString(0 << i));
        System.out.println(Integer.toBinaryString(1 << i));
        System.out.println(Integer.toBinaryString(2 << i));
        System.out.println(Integer.toBinaryString(3 << i));
        System.out.println((1 << 29) - 1);
        System.out.println(Integer.toBinaryString((1 << 29) - 1));
        System.out.println(Integer.toBinaryString(-1));
    }
}
