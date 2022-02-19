package com.cczywyc.springfx.aop.overview;

/**
 * class loader demo
 *
 * @author wangyc
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        ClassLoader parentClassLoader = classLoader;
        while (true) {
            parentClassLoader = parentClassLoader.getParent();
            if (parentClassLoader == null) {
                break;
            }
            System.out.println(parentClassLoader);
        }
    }
}
