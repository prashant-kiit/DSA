package Design_Pattern;

public class Decorator {
    public static void main(String[] args) {
        Main main = new Main();
        main.doSomething(); // original function
        Interface Interface = new DecoratorI();
        Interface.doSomething(); // decorated function
    }
}

interface Interface {
    public void doSomething();
}

class Main implements Interface {
    public void doSomething() {
        System.out.println("Main Function");
    }
}

class DecoratorI implements Interface {
    private Main main = new Main();

    public void doSomething() {
        System.out.println("Decoration Part 1");
        main.doSomething();
        System.out.println("Decoration Part 2");
    }
}

class Decorator2 implements Interface {
    private Main main = new Main();

    public void doSomething() {
        System.out.println("More Decoration Part 1");
        main.doSomething();
        System.out.println("More Decoration Part 2");
    }
}