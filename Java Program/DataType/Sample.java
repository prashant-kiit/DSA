public class Sample {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a2 = new B();
        a1.hello();
        a2.hello();
    }
}

class A {
    public void hello() {
        System.out.println("Hello A");
    }
}

class B extends A {
    @Override
    public void hello() {
        System.out.println("Hello B");
    }
}