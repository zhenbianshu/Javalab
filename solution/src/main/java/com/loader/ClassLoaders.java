package com.loader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author xiepengfei 2019/1/31
 */
public class ClassLoaders {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        List<Class<?>> classes = getClasses("zhenbianshu.com");
        Class.forName("zhenbianshu.com.asm.Attacher");
        for (Class<?> className : classes) {
        }
        System.out.println(classes);
    }


    /**
     * 根据包名查询出所有子类信息
     * @param packageName
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException,IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for(File directory:dirs){
            classes.addAll(findClass(directory, packageName));
        }
        return classes;
    }

    /**
     * 获取指定目录&包路径下的所有类
     * @param directory 文件目录路径
     * @param packageName 包名路径
     * @return
     * @throws ClassNotFoundException
     */
    private static  List<Class<?>> findClass(File directory, String packageName)
            throws ClassNotFoundException{
        List<Class<?>> classes = new ArrayList<>();
        if(!directory.exists()){
            return classes;
        }
        File[] files = directory.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClass(file, packageName+"."+file.getName()));
            }else if(file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length()-6)));
            }
        }
        return classes;
    }

    /*public static List<String> getClassName(String packageName) {
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(filePath, null);
        return fileNames;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }*/

   /* public static List<String> getClassName(String packageName, boolean childPackage) {
        List<String> fileNames = null;
        java.lang.ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if (url != null) {
            fileNames = getClassNameByFile(url.getPath(), childPackage);
        }
        return fileNames;

    }

    private static List<String> getClassNameByFile(String filePath, boolean childPackage) {
        List<String> myClassName = new ArrayList<>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                if (childPackage) {
                    myClassName.addAll(getClassNameByFile(childFile.getPath(), childPackage));
                }
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                    childFilePath = childFilePath.replace("\\", ".");
                    myClassName.add(childFilePath);
                }
            }
        }

        return myClassName;
    }*/
}
