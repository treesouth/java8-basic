package com.zn._interface._default;

/**
 * Created by zn on 16/10/12.
 * default方法的继承
 */

/**
 * 1.不覆写默认方法，直接从父接口中获取方法的默认实现。
 * 2.覆写默认方法，这跟类与类之间的覆写规则相类似。
 * 3.覆写默认方法并将它重新声明为抽象方法，这样新接口的子类必须再次覆写并实现这个抽象方法。
 */
public class Default2 {
    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    interface InterfaceB extends InterfaceA {
    }

    interface InterfaceC extends InterfaceA {
        @Override
        default void foo() {
            System.out.println("InterfaceC foo");
        }
    }

    interface InterfaceD extends InterfaceA {
        @Override
        void foo();
    }

    public static void main(String[] args) {
        new InterfaceB() {
        }.foo(); // 打印：“InterfaceA foo”
        new InterfaceC() {
        }.foo(); // 打印：“InterfaceC foo”
        new InterfaceD() {
            @Override
            public void foo() {
                System.out.println("InterfaceD foo");
            }
        }.foo(); // 打印：“InterfaceD foo”

        // 或者使用 lambda 表达式
        ((InterfaceD) () -> System.out.println("InterfaceD foo")).foo();
    }
}
