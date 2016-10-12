package com.zn._interface._default;

/**
 * Created by zn on 16/10/12.
 *
 * ClassA 类并没有实现 InterfaceA 接口中的 foo 方法，InterfaceA 接口中提供了 foo 方法的默认实现，
 * 因此可以直接调用 ClassA 类的 foo 方法
 */
public class Default1 implements InterfaceA {

    public static void main(String[] args) {
        new Default1().foo(); // “InterfaceA foo”
    }
}

interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}
