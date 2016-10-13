package com.zn.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zn on 16/10/13.
 */
public class Lambda3 {

    public static void main(String[] args) throws Exception {

        //Predicates

        //pre java8
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };
        //after java8
        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean test1 = predicate.test("foo");  // true
        //length() > 0
        System.out.println("test1 = " + test1);
        //取反negate()
        boolean test2 = predicate.negate().test("foo");  // false

        System.out.println("test2 = " + test2);

        Predicate<Boolean> nonNull_1 = (obj) -> Objects.nonNull(obj);//使用 Lambda 表达式
        Predicate<Boolean> nonNull_2 = Objects::nonNull;//使用方法引用的方式
        Predicate<Boolean> isNull = Objects::isNull;

        System.out.println(isNull.test(null));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isEmpty.test("not empty"));

        //Functions
        Function<String, Integer> str2Int = Integer::valueOf;
        Function<String, String> int2Str = str2Int.andThen(String::valueOf);

        System.out.println(int2Str.apply("123")); //123

        //Suppliers
        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get().firstName); //"null"

        Person get = personSupplier.get();   // new Person
        get.firstName = "new person's first name";
        System.out.println(get.firstName);//"new person's first name"

        // Consumers
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        // Comparators
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2)); // >0
        System.out.println(comparator.reversed().compare(p1, p2)); // <0

        // Runnables
        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();

        // Callables
        // Callable中的call()方法类似Runnable的run()方法，就是前者有返回值，后者没有

        Callable<UUID> callable = new Callable<UUID>() {
            @Override
            public UUID call() throws Exception {
                UUID temp = UUID.randomUUID();
                System.out.println("call math = " + Math.random() + " , UUID = " + temp.toString());
                return temp;
            }
        };
//        callable.call();
        ExecutorService executor = Executors.newCachedThreadPool();
//        executor.execute(runnable);

//        submit and execute : Method submit extends base method Executor#execute(Runnable)} by creating and returning a {@link Future} that can be used to cancel execution and/or wait for completion

        System.out.println(executor.submit(callable).get().toString());
//        System.out.println(executor.submit(runnable).get().toString());//"null"
    }
}
