package com.zn.lambda;

import java.util.*;

/**
 * Created by zn on 16/10/13.
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //Method 1
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //Method 2
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //Method 3
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //Method 4
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //Method 1,2,3,4 Output
        System.out.println(names);

        //-----------------------------------------

        //逆序排序
        names.sort(Collections.reverseOrder());
        System.out.println("reverseOrder = " + names);

        //-----------------------------------------

        //null置前
        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsFirst(String::compareTo));
        System.out.println("null is first = " + names2);

        //-----------------------------------------

        List<String> names3 = null;

        //判断可空对象是否为空
        boolean flag = Optional.ofNullable(names3).isPresent();
        System.out.println(flag);

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
        System.out.println(names3);

    }
}
