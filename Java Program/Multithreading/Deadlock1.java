public class Deadlock1 {
    static int n = 4; // stored in closure

    private static Square getSquareFunctionObject() {
        // lambda function
        // Square foo = x -> x * n;
        // anonymous class
        Square foo = new Square() {
            @Override
            public int square(int x) {
                return x * n;
            }
        };
        return foo;
    }

    public static void main(String[] args) {
        System.out.println(getSquareFunctionObject().square(3));
    }
}

@FunctionalInterface
interface Square {
    int square(int x);
}

// macro C
// pointer function C
// inline function C++
// lambda function C++
// lambda function Java
// closure
// functional interface
// anonymous class
// inner class