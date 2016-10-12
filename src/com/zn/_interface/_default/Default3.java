package com.zn._interface._default;

/**
 * Created by zn on 16/10/12.
 * 默认方法的多继承
 */

/**
 * 1.在 ClassA 类中，它实现的 InterfaceA 接口和 InterfaceB 接口中的方法不存在歧义，可以直接多实现。
 * 2.在 ClassB 类中，它实现的 InterfaceB 接口和 InterfaceC 接口中都存在相同签名的 foo 方法，需要手动解决冲突。
 * 覆写存在歧义的方法，并可以使用 InterfaceName.super.methodName(); 的方式手动调用需要的接口默认方法。
 */
public class Default3 {

    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    interface InterfaceB {
        default void bar() {
            System.out.println("InterfaceB bar");
        }
    }

    interface InterfaceC {
        default void foo() {
            System.out.println("InterfaceC foo");
        }

        default void bar() {
            System.out.println("InterfaceC bar");
        }
    }

    public static void main(String[] args) {
        new ClassB().bar();
    }
}

class ClassA implements InterfaceA, Default3.InterfaceB {
}

// 错误
//class ClassB implements InterfaceB, InterfaceC {
//}
 class ClassB implements Default3.InterfaceB, Default3.InterfaceC {
    @Override
    public void bar() {
        Default3.InterfaceB.super.bar(); // 调用 InterfaceB 的 bar 方法
        Default3.InterfaceC.super.bar(); // 调用 InterfaceC 的 bar 方法
        System.out.println("ClassB bar"); // 做其他的事
    }
}
