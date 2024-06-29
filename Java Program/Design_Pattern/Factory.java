package Design_Pattern;

import java.util.HashMap;

// Application
public class Factory {
    public static void main(String[] args) {
        // Autowire
        OSFactory osFactory = OSFactory.getOSFactorySingletonObject();
        // Autowire
        OS os1 = osFactory.getOS("Android");
        OS os4 = osFactory.getOS("Android");
        os1.getDetails();
        System.out.println(os1.hashCode());
        System.out.println(os4.hashCode());

        // Autowire
        OS os2 = osFactory.getOS("IOS");
        OS os5 = osFactory.getOS("IOS");
        os2.getDetails();
        System.out.println(os2.hashCode());
        System.out.println(os5.hashCode());

        // Autowire
        OS os3 = osFactory.getOS("Windows");
        OS os6 = osFactory.getOS("Windows");
        os3.getDetails();
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
    public OS getOS(String OSName) {
        // configuation.xml
        // bean
        if (OSName.equals("android")) {
            if (!beanContainer.containsKey("android") == true) {
                beanContainer.put("android", new Android());
            }
            return beanContainer.get("android");
        }
        // bean
        if (OSName.equals("ios")) {
            if (!beanContainer.containsKey("ios") == true) {
                beanContainer.put("ios", new IOS());
            }
            return beanContainer.get("ios");
        }
        // bean
        if (!beanContainer.containsKey("windows") == true) {
            beanContainer.put("windows", new Windows());
        }
        return beanContainer.get("windows");
    }
}

interface OS {
    public void getDetails();
}

// Component
class Android implements OS {
    @Override
    public void getDetails() {
        System.out.println("I am Android");
    }
}

// Component
class IOS implements OS {
    @Override
    public void getDetails() {
        System.out.println("I am IOS");
    }
}

// Component
class Windows implements OS {
    @Override
    public void getDetails() {
        System.out.println("I am Windows");
    }
}