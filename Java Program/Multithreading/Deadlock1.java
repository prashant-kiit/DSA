// Problem : Circular Invocation in Nested Locks causes Deadlock
// Solution : Linear invocation, Non nested Lock
// Explaation : https://www.youtube.com/watch?v=NUazC4EUG50
public class Deadlock1 {
    public static void main(String[] args) {
        Resourse resourse1 = new Resourse("House");
        Resourse resourse2 = new Resourse("Car");

        new Thread(new Runnable() {
            @Override
            public void run() {
                // reqiured Lock and Semaphore
                // entry point
                // critical section
                resourse1.modify(resourse2);
                // exit point
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // reqiured Lock and Semaphore
                // entry point
                // critical section
                resourse2.modify(resourse1);
                // exit point
            }
        }).start();
    }
}

class Resourse {
    String name;

    Resourse(String name) {
        this.name = name;
    }

    // synchronized by storing in Disk
    synchronized public void modify(Resourse otherResourse) {
        System.out.println("Enters resourse " + name);
        Util.sleep(1000);
        // reqiured Lock and Semaphore
        // entry point
        // critical section
        otherResourse.print();
        // exit section
    }

    // synchronized by storing in Disk
    synchronized private void print() {
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