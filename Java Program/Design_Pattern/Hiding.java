package Design_Pattern;

public class Hiding {
    public static void main(String[] args) {
        B b = new B();
        b.show();
        b.show(1);  
    }
}

class A {
    void show(int i) {
        System.out.println("A class");
    }
}

class B extends A {
    void show() {
        System.out.println("B class");
    }
}
