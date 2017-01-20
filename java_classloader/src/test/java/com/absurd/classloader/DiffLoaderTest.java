package com.absurd.classloader;

import org.junit.Test;

import java.lang.reflect.Method;

/****
 *
 */
public class DiffLoaderTest {
    @Test
    public void testClassIdentity() {
        String classDataRootPath = "E:\\myfork\\java-face\\java_classloader\\target\\classes";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.absurd.classloader.Simple";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSimple", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
