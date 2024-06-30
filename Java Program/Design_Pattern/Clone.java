package Design_Pattern;

public class Clone {
    public static void main(String[] args) {
        A a = new A();
        A a2 = a;
        System.out.println(a.i + "-" + a.j + "-" + a.b.hashCode());
        System.out.println(a2.i + "-" + a2.j + "-" + a2.b.hashCode());
        
        a.i = 1;
        a2.b = new B();
        System.out.println(a.i + "-" + a.j + "-" + a.b.hashCode());
        System.out.println(a.i + "-" + a.j + "-" + a.b.c.hashCode());
        System.out.println(a2.i + "-" + a2.j + "-" + a2.b.hashCode());
        System.out.println(a2.i + "-" + a2.j + "-" + a2.b.c.hashCode());

        A a3 = new A();
        a3.i = 10;
        a3.j = 20;
        System.out.println(a.i + "-" + a.j + "-" + a.b.hashCode());
        System.out.println(a.i + "-" + a.j + "-" + a.b.c.hashCode());
        System.out.println(a3.i + "-" + a3.j + "-" + a3.b.hashCode());
        System.out.println(a3.i + "-" + a3.j + "-" + a3.b.c.hashCode());
    }
}

class A {
    int i = 0;
    int j = 1;
    B b = new B();    
}

class B {
    C c = new C();
}


class C {

}