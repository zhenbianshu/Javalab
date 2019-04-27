package io.github.zhenbianshu.common;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zbs 2019/3/11
 */
public class UURL {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("xxxx");
        System.out.println(url.getHost());

    }
}
