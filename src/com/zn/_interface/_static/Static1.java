package com.zn._interface._static;

/**
 * Created by zn on 16/10/12.
 */
public class Static1 {

    interface InterfaceA {
        default void foo() {
            printHelloWorld();
        }

        //接口中的静态方法必须是 public 的，public 修饰符可以省略，static 修饰符不能省略。
        static void printHelloWorld() {
            System.out.println("hello, world");
        }
    }

    public static void main(String[] args) {
        InterfaceA.printHelloWorld(); // 打印：“hello, world”
    }
}
