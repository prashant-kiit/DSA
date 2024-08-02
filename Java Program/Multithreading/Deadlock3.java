public class Deadlock3 {
    public static void main(String[] args) {
        Resourse resourse1 = new Resourse("House");
        Resourse resourse2 = new Resourse("Car");

        new Thread(new Runnable() {
            @Override
            public void run() {
                // reqiured Lock and Semaphore
                // entry point
                // critical section
                synchronized (resourse1) {
                    resourse1.modify(resourse2);
                }
                // exit point
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // reqiured Lock and Semaphore
                // entry point
                // critical section
                synchronized (resourse2) {
                    resourse2.modify(resourse1);
                }
                // exit point
            }
        }).start();
    }

    // Remove anyone synchronized keyword to resolve
}

class Resourse {
    String name;

    Resourse(String name) {
        this.name = name;
    }

    public void modify(Resourse otherResourse) {
        System.out.println("Enters resourse " + name);
        Util.sleep(1000);
        // reqiured Lock and Semaphore
        // entry point
        // critical section
        synchronized (otherResourse) {
            otherResourse.print();
        }
        // exit section
    }

    private void print() {
        Util.sleep(1000);
        System.out.println("Exits resourse " + name);
    }
}

class Util {
    // Util class to sleep a thread
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}