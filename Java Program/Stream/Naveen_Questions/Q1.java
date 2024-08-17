package Naveen_Questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q1 {
    public static void main(String[] args) {
        // flat map
        List<int[]> listOfIntArrays = Arrays.asList(
                new int[] { 1, 2, 3 },
                new int[] { 4, 5 },
                new int[] { 6, 7, 8, 9 });

        listOfIntArrays.stream().flatMapToInt(Arrays::stream).forEach(System.out::println);

        // sum
        List<Integer> list = Arrays.asList(1, 2, 22, 3, 4, 5, 1, 2, 3, 4, 5);
        list.stream().reduce((a, b) -> a + b).ifPresentOrElse(System.out::println, new Runnable() {
            @Override
            public void run() {
                System.out.println("No Sum");
            }
        });
        Integer sum = list.stream().reduce(10, (a, b) -> a + b);
        System.out.println(sum);

        // average
        System.out.println(list.stream().mapToInt(e -> e).average().getAsDouble());

        // list of squares
        System.out.println(list.stream().map(n -> n * n).filter(n -> n > 10).mapToInt(n -> n).average().getAsDouble());

        // print even and odd
        System.out.println(list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));

        // check number prefix 2
        System.out.println(list.stream()
                .map(n -> n + "")
                .filter(s -> s.charAt(0) == '2')
                .map(Integer::valueOf)
                .collect(Collectors.toList()));

        // find duplicate values only
        System.out.println(list.stream().filter(n -> Collections.frequency(list, n) > 1).collect(Collectors.toSet()));

        // only unique values
        System.out.println(list.stream().collect(Collectors.toSet()));

        // A with B(Q) -> Apple , Banana
        List<B> bl1 = Arrays.asList(new B("P"), new B("Q"), new B("R"), new B("S"));
        List<B> bl2 = Arrays.asList(new B("X"), new B("Q"), new B("Y"), new B("S"));
        List<B> bl3 = Arrays.asList(new B("P"), new B("T"), new B("Y"), new B("S"));

        List<A> al = Arrays.asList(new A("Apple", bl1), new A("Banana", bl2), new A("Cucumber", bl3));

        System.out.println(
                al.stream()
                        .filter(a -> {
                            Boolean isQ = a.bl.stream().map(b -> b.name).anyMatch(name -> name.equals("Q"));
                            Boolean isS = a.bl.stream().map(b -> b.name).anyMatch(name -> name.equals("S"));
                            return isQ && isS;

                            // return a.bl.stream().map(b -> b.name)
                            // .anyMatch(name -> name.equals("Q"));
                        })
                        .map(a -> a.name)
                        .collect(Collectors.toList()));

        // count occurences a char in string
        String str = "Prashant";
        System.out.println(str.chars().filter(c -> (char) c == 'a').count());
    }
}

class A {
    String name = null;
    List<B> bl = null;

    A(String name, List<B> bl) {
        this.name = name;
        this.bl = bl;
    }
}

class B {
    String name = null;

    B(String name) {
        this.name = name;
    }
}
