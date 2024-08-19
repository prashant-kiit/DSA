public class Closure2 {
    static int n = 4; // stored in closure

    // inner class
    static class Square {
        public int square(int x) {
            return x * n;
        }
    }

    private static Square getSquareFunctionObject() {
        Square foo = new Square();
        return foo;
    }

    public static void main(String[] args) {
        System.out.println(getSquareFunctionObject().square(3));
    }

}