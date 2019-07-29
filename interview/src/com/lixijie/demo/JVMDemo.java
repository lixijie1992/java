package com.lixijie.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * JVM调试demo
 */
public class JVMDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[5*1024*1024];
        /*强引用*/
        Object o1 = new Object();
        /*弱引用*/
        Object o2 = new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<Object>(o2);
        /*软引用*/
        Object o3 = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(o3);
        /*虚引用；与引用队列一起使用*/
        Object o4 = new Object();
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> objectPhantomReference = new PhantomReference<>(o4, objectReferenceQueue);



    }
}
