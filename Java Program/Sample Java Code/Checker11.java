package Checker;

class Checker11 {
    public static void main(String[] args) {
        System.out.println(Outer.a);
        System.out.println(new Outer().d);
        System.out.println(new Outer().new Inner().c);
        System.out.println(Outer.Inner2.e);
        System.out.println(new Outer.Inner2().f);
        System.out.println(Outer.Inner.b);
    }
}
                                                                        
class Outer {
    int d = 6;
    static int a = 2;

    class Inner {
        Inner() {};
        int c = 4;
        static int b = 2; // this can make Inner class behave as static

        void show() {
            System.out.println(d);
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
            System.out.println(new Inner2().f);
            System.out.println(Inner2.e);
        }

        static void show2() {
            // System.out.println(d); // Cannot make a static reference to the non-static field d
            System.out.println(a);
            // System.out.println(c); // Cannot make a static reference to the non-static field c
            System.out.println(b);
            System.out.println(new Inner2().f);
            System.out.println(Inner2.e);
        }
    }

    static class Inner2 {
        Inner2() {};
        int f = 4;
        static int e = 2;

        void show() {
            // System.out.println(d); // Cannot make a static reference to the non-static field d
            System.out.println(a);
            // System.out.println(new Inner().c); // Cannot make a static reference to the non-static class
            System.out.println(Inner.b);
            System.out.println(f);
            System.out.println(e);
        }

        static void show2() {
            // System.out.println(d); // Cannot make a static reference to the non-static field d
            System.out.println(a);
            // System.out.println(new Inner().c); // Cannot make a static reference to the non-static class
            System.out.println(Inner.b);
            // System.out.println(f); // Cannot make a static reference to the non-static field f
            System.out.println(e);
        }
    }

    void show() {
        System.out.println(d);
        System.out.println(a);
        System.out.println(new Inner().c);
        System.out.println(Inner.b);
        System.out.println(new Inner2().f);
        System.out.println(Inner2.e);
    }

    static void show2() {
        // System.out.println(d); // Cannot make a static reference to the non-static field d
        System.out.println(a);
        // System.out.println(new Inner().c); // Cannot make a static reference to the non-static inner class
        System.out.println(Inner.b);
        System.out.println(new Inner2().f);
        System.out.println(Inner2.e);
    }
}

