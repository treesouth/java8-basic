package com.zn.lambda;

/**
 * Created by zn on 16/10/13.
 */
public class Lambda2 {

    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);

        default void convertReal(Object obj) {
            System.out.println(String.valueOf(obj));
        }
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);

        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123

        //指向静态方法的方法引用
        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123

        //指向现有对象的实例方法的方法引用
        Something something = new Something();
        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // constructor reference 构造函数的方法引用
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.firstName);
    }
}
