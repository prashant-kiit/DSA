package Sample_Java_Code;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Checker13 {
    public static void main(String[] args) {
        // primitive data type
        int a = 2;
        int b = 2;
        System.out.println(a == b);
        // System.out.println(a.equals(b));

        // wrapper class
        Integer c = 2;
        Integer d = 2;
        System.out.println(c.hashCode());
        System.out.println(c.hashCode());
        System.out.println(c == d);
        System.out.println(c.equals(d));

        Set<Integer> integerset = new HashSet<>();
        integerset.add(c);
        integerset.add(d);
        System.out.println(integerset);

        // string classes
        String e = "abc";
        String f = "abc";
        System.out.println(e.hashCode());
        System.out.println(e.hashCode());
        System.out.println(e == f);
        System.out.println(e.equals(f));
        System.out.println(e.compareTo(f));

        Set<String> stringset = new HashSet<>();
        stringset.add(e);
        stringset.add(f);
        System.out.println(stringset);

        // other classes
        A g = new A("xyz");
        A h = new A("xyz");
        A i = g;
        System.out.println(g.hashCode());
        System.out.println(h.hashCode());
        System.out.println(i.hashCode());
        System.out.println(g == h);
        System.out.println("g.equals(h)");
        System.out.println(g.equals(h));

        // https://medium.com/@viveksinghggits/internal-working-of-hashset-how-it-ensures-not-to-store-duplicate-objects-c1eb2e9244e8
        Set<A> aset = new HashSet<>();
        aset.add(g);
        aset.add(h);
        System.out.println(aset);

        System.out.println(Collections.frequency(aset, a));
        // Collections.sort(null);
        // Collections.sort(null, null);

        // deep copy with serialization
        // https://howtodoinjava.com/java/serialization/how-to-do-deep-cloning-using-in-memory-serialization-in-java/#:~:text=Java%20deep%20copy%20example&text=Whenever%20invoked%20on%20an%20instance,have%20used%20ByteArrayOutputStream%20and%20ObjectOutputStream%20.
    }
}

class A {
    String name;

    A(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object a) {
        A a1 = (A) a;
        // return this.name.equals(a1.name);
        return this.name.compareTo(a1.name) == 0 ? true : false;
    }

    @Override
    public int hashCode() {
        int hashNumber = 0;
        int k = 1;
        for (int i = this.name.length() - 1; i >= 0; i--) {
            hashNumber = hashNumber + this.name.charAt(i) * k;
            int factor = (this.name.charAt(i) / 100) < 1 ? 100 : 1000;
            k = k * factor;
        }
        return hashNumber;
    }
}

class ComparatorA implements Comparator<A> {
    @Override
    public int compare(A a1, A a2) {
        return a1.name.compareTo(a2.name);
    }
}