package com.common;

import org.apache.commons.lang.StringUtils;

/**
 * @author zbs 2019/2/28
 */
public class SubString {
    public static void main(String[] args) {
        String test = "abcdefg";
        System.out.println(StringUtils.substring(test, 0, test.length() - 1));
    }
}
