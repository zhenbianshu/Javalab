package io.github.zhenbianshu.common;

import java.util.HashSet;
import java.util.Set;

/**
 * created by xiepengfei on 2019/1/12
 */
public class Combination {

    public static void main(String[] args) {
        String[] m = {"A", "B", "C", "D", "E"};
        Set<Set<String>> combinationAll = combination(m);
        System.out.println(combinationAll);

    }

    private static Set<Set<String>> combination(String[] m) {
        Set<Set<String>> result = new HashSet<>();

        for (int i = 1; i < Math.pow(2, m.length) - 1; i++) {
            Set<String> eligibleCollections = new HashSet<>();
            // 依次将数字 i 与 2^n 按位与，判断第 n 位是否为 1
            for (int j = 0; j < m.length; j++) {
                if ((i & (int) Math.pow(2, j)) == Math.pow(2, j)) {
                    eligibleCollections.add(m[j]);
                }
            }
            result.add(eligibleCollections);
        }
        return result;
    }
}


