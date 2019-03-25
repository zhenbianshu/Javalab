package com.common;

import java.net.URL;
import java.util.Enumeration;

/**
 * @author zbs 2019/3/9
 */
public class ResourceLoader {
    static {
        System.out.println("xxxxxxxx");
    }

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        Enumeration<URL> resources = classLoader.getResources("test");
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            System.out.println(resource.getFile());
        }
    }
}
