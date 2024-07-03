import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test1 {
    public static void main(String[] args) {
        // Function
        // apply
        int x = 100;
        Function<Integer, String> fun = (num) -> {
            if (num > x)
                return "Hello";
            else
                return "World";
        }; // apply(){}

        String response = fun.apply(4);
        System.out.println(response);

        // before
        Function<Integer, Integer> fun2 = num -> num * 100; // apply(){}
        Function<Integer, Integer> fun3 = num2 -> num2 * num2; // apply(){}
        Function<Integer, Integer> fun4 = fun2.compose(fun3); // compose(){} // fun4 = num -> apply(fun3.apply(num))
        Integer result = fun4.apply(4);
        System.out.println(result);

        // after
        System.out.println(fun2.andThen(fun3).apply(4)); // anThen(){} // num -> fun3.apply(apply(num))

        // identity
        Function<Integer, Integer> fun5 = Function.identity();
        System.out.println(fun5.apply(10));

        // Supplier
        // get
        Supplier<Integer> supplier = () -> 2;
        System.out.println(supplier.get());

        // Consumer
        // accept
        Consumer<String> consumer = s -> System.out.println("Hello " + s);
        consumer.accept("World");

        // andThen
        Consumer<String> consumer2 = s -> System.out.println("Namaste " + s);
        consumer.andThen(consumer2).accept("Chennai");

        // Predicate
        // test
        Predicate<Integer> predicate = num -> num % 2 == 0;
        System.out.println(predicate.test(4));

        // negate
        System.out.println(predicate.negate().test(4));

        // not
        System.out.println(Predicate.not(predicate).test(4));

        // and
        Predicate<Integer> predicate2 = num -> num % 10 == 0;
        System.out.println(predicate.and(predicate2).test(4));

        // or
        System.out.println(predicate.or(predicate2).test(4));
    }
}

interface A {
    static void foo() {
        System.out.println("A Class");
    }
}

class B implements A {
}