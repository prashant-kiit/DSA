public class Deadlock2 {
    public static void main(String[] args) {
        // creating one object
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        // creating first thread and starting it
        Thread1 t1 = new Thread1(s1, s2);
        t1.setName("Thread1");
        t1.start();
        // creating second thread and starting it
        Thread2 t2 = new Thread2(s1, s2);
        t2.setName("Thread2");
        t2.start();
        Util.sleep(2000);
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

// This class is shared by both threads
class Shared {
    // first synchronized method
    synchronized void test(Shared otherS) {
        System.out.println(Thread.currentThread().getName() + " enters test of " + this);
        Util.sleep(1000);
        // taking object lock of s2 enters
        // into test2 method
        otherS.hello();
        System.out.println(Thread.currentThread().getName() + " exits test of " + this);
    }

    synchronized void hello() {
        System.out.println(Thread.currentThread().getName() + " enters hello of " + this);
        Util.sleep(1000);
        // taking object lock of s1 enters
        // into test1 method
        System.out.println(Thread.currentThread().getName() + " exits hello of " + this);
    }
}

class Thread1 extends Thread {
    private Shared s1;
    private Shared s2;

    // constructor to initialize fields
    public Thread1(Shared s1, Shared s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // run method to start a thread
    @Override
    public void run() {
        s1.test(s2);
    }
}

class Thread2 extends Thread {
    private Shared s1;
    private Shared s2;

    // constructor to initialize fields
    public Thread2(Shared s1, Shared s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // run method to start a thread
    @Override
    public void run() {
        s2.test(s1);
    }
}
