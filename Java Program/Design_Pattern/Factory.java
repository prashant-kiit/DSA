package Design_Pattern;

import java.util.HashMap;

// Application
public class Factory {
    public static void main(String[] args) throws Exception {
        // Autowire
        OSFactory osFactory = OSFactory.getOSFactorySingletonObject();
        // Autowire
        OS os1 = osFactory.getOS("linux");
        OS os4 = osFactory.getOS("linux");
        os1.run();
        System.out.println(os1.hashCode());
        System.out.println(os4.hashCode());

        // Autowire
        OS os2 = osFactory.getOS("mac");
        OS os5 = osFactory.getOS("mac");
        os2.run();
        System.out.println(os2.hashCode());
        System.out.println(os5.hashCode());

        // Autowire
        OS os3 = osFactory.getOS("windows");
        OS os6 = osFactory.getOS("windows");
        os3.run();
        System.out.println(os3.hashCode());
        System.out.println(os6.hashCode());
    }
}

// Configuration
// Component
class OSFactory {
    // Containers
    private static OSFactory osFactory = null;
    private static HashMap<String, OS> beanContainer = null;

    // Qualifier
    public static OSFactory getOSFactorySingletonObject() {
        // bean
        if (osFactory == null) {
            osFactory = new OSFactory();
            beanContainer = new HashMap<String, OS>();
            return osFactory;
        }
        return osFactory;
    }

    // Qualifier
    public OS getOS(String OSName) throws Exception {
        if (!beanContainer.containsKey(OSName) == true) {
            // Configuration
            if (OSName.equals("windows"))
                beanContainer.put(OSName, new Windows()); // Bean
            else if (OSName.equals("linux"))
                beanContainer.put(OSName, new Linux()); // Bean
            else if (OSName.equals("mac"))
                beanContainer.put(OSName, new MacOS()); // Bean
            else
                throw new Exception("No component of name " + OSName + " found");
        }
        return beanContainer.get(OSName);
    }
}

interface OS {
    public void run();
}

// Component
class Windows implements OS {
    @Override
    public void run() {
        System.out.println("I am Windows");
    }
}

// Component
class Linux implements OS {
    @Override
    public void run() {
        System.out.println("I am Linux");
    }
}

// Component
class MacOS implements OS {
    @Override
    public void run() {
        System.out.println("I am Mac");
    }
}