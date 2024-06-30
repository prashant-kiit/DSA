package Design_Pattern;

public class Facade {
    public static void main(String[] args) {
        Interface Interface = new Decorator();
        Interface.doSomething();
    }
}

interface Interface {
    public void doSomething();
}

class Main implements Interface {
    public void doSomething() {
        System.out.println("Main");
    }
}

class Decorator implements Interface {
    public void doSomething() {
        Main main = new Main();
        main.doSomething();
        System.out.println("Decorator");
    }
}