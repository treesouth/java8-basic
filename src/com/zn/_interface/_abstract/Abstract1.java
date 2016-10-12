package com.zn._interface._abstract;

/**
 * Created by zn on 16/10/12.
 */

/**
 * 类的方法声明优先于接口默认方法，无论该方法是具体的还是抽象的。
 */
public class Abstract1 {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.foo(); // 打印：“InterfaceA foo”
        classA.bar(); // 打印：“AbstractClassA bar”
    }

    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }

        default void bar() {
            System.out.println("InterfaceA bar");
        }
    }
}

abstract class AbstractClassA {
    public abstract void foo();

    public void bar() {
        System.out.println("AbstractClassA bar");
    }
}

class ClassA extends AbstractClassA implements Abstract1.InterfaceA {
    @Override
    public void foo() {
        Abstract1.InterfaceA.super.foo();
    }
}