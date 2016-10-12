package com.zn._interface._default;

/**
 * Created by zn on 16/10/12.
 */
public class Default5 {

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

    interface InterfaceC extends InterfaceA {
        @Override
        default void foo() {
            /**
             * 虽然 InterfaceC 接口的 foo 方法只是调用了一下父接口的默认实现方法，但是这个覆写 不能省略，
             * 否则 InterfaceC 接口中继承自 InterfaceA 接口的隐式的 foo 方法同样会被认为是被 InterfaceB 接口覆写了而被屏蔽，
             * 会导致调用 InterfaceC.super.foo() 时出错。
             */
            InterfaceA.super.foo();
        }
    }
    class ClassA implements Default5.InterfaceB, Default5.InterfaceC {
        @Override
        public void foo() {
            Default5.InterfaceB.super.foo();
            Default5.InterfaceC.super.foo();
        }
    }

}


