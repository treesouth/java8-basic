package com.zn._interface._default;

/**
 * Created by zn on 16/10/12.
 * <p>
 * 接口继承行为发生冲突时的解决规则
 */
public class Default4 {
    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    interface InterfaceB extends InterfaceA {
        @Override
        default void foo() {
            System.out.println("InterfaceB foo");
        }
    }

    // 正确
    class ClassA implements InterfaceA, InterfaceB {
    }

    /**
     * 1.InterfaceB 接口继承了 InterfaceA 接口，那么 InterfaceB 接口一定包含了所有 InterfaceA 接口中的字段方法，
     * 因此一个同时实现了 InterfaceA 接口和 InterfaceB 接口的类与一个只实现了 InterfaceB 接口的类完全等价。
     * 2.覆写意味着对父类方法的屏蔽，这也是 Override 的设计意图之一。
     * 因此在实现了 InterfaceB 接口的类中无法访问已被覆写的 InterfaceA 接口中的 foo 方法。
     */
    class ClassB implements InterfaceA, InterfaceB {
        @Override
        public void foo() {
            /**
             * 被其它类型所覆盖的方法会被忽略
             */
//        InterfaceA.super.foo(); // 错误
            InterfaceB.super.foo();
        }
    }
}





