package com.cczywyc.springfx.aop;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * target filter
 * @author wangyc
 */
public class TargetFilterDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.cczywyc.springfx.aop.EchoService";
        //current thread classloader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //target class name
        Class<?> targetClass = classLoader.loadClass(targetClassName);
        //sprint reflect util class
        Method targetMethod = ReflectionUtils.findMethod(targetClass, "echo", String.class);
        System.out.println(targetMethod);

        //find the method throws NullPointerException
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("only throws NullPointerException of method is:" + method);
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                return parameterTypes.length == 1
                        && String.class.equals(parameterTypes[0])
                        && exceptionTypes.length == 1
                        && NullPointerException.class.equals(exceptionTypes[0]);
            }
        });
    }
}
