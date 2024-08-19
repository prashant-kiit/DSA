package Design_Pattern;

public class Facade {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.start();
    }
}

// Facade
class Kitchen {
    private Ration ration = new Ration();
    private Cook cook = new Cook();
    private Serve serve = new Serve();

    public void start() {
        ration.getRation();
        cook.cook();
        serve.serve();
    }
}

class Ration {
    public void getRation() {
        System.out.println("Got ration");
    }
}

class Cook {
    public void cook() {
        System.out.println("Food cooked");
    }
}

class Serve {
    public void serve() {
        System.out.println("Food served");
    }
}
