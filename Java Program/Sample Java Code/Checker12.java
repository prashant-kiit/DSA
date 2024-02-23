package Checker;

import java.util.function.Function;
import java.util.function.Predicate;

/*
https://www.codingdojo.com/blog/what-is-functional-programming#:~:text=Many%20programming%20languages%20and%20dialects,use%20features%20found%20in%20FP.
*/

/*
https://www.geeksforgeeks.org/callable-future-java/
https://www.geeksforgeeks.org/future-and-futuretask-in-java/
https://www.educative.io/answers/how-to-get-the-result-of-a-future-in-java
*/

/*
https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
https://www.geeksforgeeks.org/stream-in-java/ 
*/

@FunctionalInterface
interface Upper {
    void show();
}

interface Topper {
    default void foo() {
        System.out.println("default method foo in Topper, overridden in Lower");
    }

    default void chaalu() {
        System.out.println("default method chaalu in Topper, not overridden in Lower");
    }

    static void shuru() {
        System.out.println("static method shuru in Topper, cannot be overridden in Lower, Method Hiding");
    }
}

class Lower implements Upper, Topper {
    @Override
    public void show() {
        System.out.println("in Lower");
    }

    @Override
    public void foo() {
        System.out.println("in Lower Overridden");
    }

    void checker() {
        System.out.println("in Higher");
    }
}

public class Checker12 {
    public static void main(String[] args) {
        Lower l = new Lower();
        l.show();

        int closure = 3;
        Upper u = new Upper() {
            @Override
            public void show() {
                System.out.println("in Upper Anonymous and closure = " + closure);
            }
        };
        u.show();

        Upper u1 = () -> System.out.println("Lambda in Upper");
        u1.show();

        Lower l1 = new Lower();
        l1.foo();

        Topper t = new Topper() {
            public void foo() {
                System.out.println("in Topper Anonymous ");
            };
        };
        t.foo();

        Lower l2 = new Lower();
        l2.chaalu();

        Topper.shuru();

        Lower t3 = new Lower() {
            void checker() {
                System.out.println("checker closure = " + closure);
            }
        };
        t3.checker();

        Function<Integer, Double> half = a -> a / 2.0;
        Double ans = half.apply(10);
        System.out.println(ans);

        Function<Integer, Double> composed = half.andThen(a -> 3 * a);
        composed.apply(10); 
        
    }
}


