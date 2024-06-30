package Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesign {
    public static void main(String[] args) {
        Leaf hydrogen = new Leaf("Hydrogen", 2);
        Leaf oxygen = new Leaf("Oxygen", 1);
        Composite water = new Composite("Water");
        water.addComponent(hydrogen);
        water.addComponent(oxygen);

        Leaf carbon = new Leaf("Carbon", 2);
        Leaf oxygen1 = new Leaf("Oxygen", 1);
        Leaf hydrogen1 = new Leaf("Hydrogen", 6);
        Composite alcohol = new Composite("Alcohol");
        alcohol.addComponent(carbon);
        alcohol.addComponent(oxygen1);
        alcohol.addComponent(hydrogen1);

        Composite soap = new Composite("Soap");
        soap.addComponent(water);
        soap.addComponent(alcohol);

        soap.showComponents();
    }
}

interface Component {
    void showComponents();
}

class Leaf implements Component {
    private String name = null;
    private Integer price = null;

    public Leaf(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showComponents() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " : " + price;
    }
}

class Composite implements Component {
    private String name = null;
    private List<Component> components = new ArrayList<Component>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void showComponents() {
        System.out.println(this);
        for (Component component : components) {
            component.showComponents();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
