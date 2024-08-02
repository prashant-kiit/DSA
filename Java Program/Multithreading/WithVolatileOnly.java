public class WithVolatileOnly {
    public static void main(String[] args) throws InterruptedException {
        Resourse resourse = new Resourse();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // critical section
                    resourse.value++; // 3 step instruction
                    // System.out.println(resourse.value);
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // critical section
                    resourse.value--; // 3 step instruction
                    // System.out.println(resourse.value);
                }
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(resourse.value); // race condition happening
    }
}

// Shared Resource
class Resourse {
    volatile int value = 0;
}
