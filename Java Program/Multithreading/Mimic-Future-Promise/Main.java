import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // hook
        Fate fate1 = Fate.loadInQueue(() -> {
            for (int i = 0; i < 1; i++) {
            }
            return "ok1";
        });

        Fate fate2 = Fate.loadInQueue(() -> {
            for (int i = 0; i < 10; i++) {
            }
            return "ok2";
        });

        Fate fate3 = Fate.loadInQueue(() -> {
            for (int i = 0; i < 100; i++) {
            }
            return "ok3";
        });

        System.out.println(fate3.get());
        System.out.println(fate2.get());
        System.out.println(fate1.get());
        // System.out.println("Main");
    }
}

// Engine
class Fate {
    static {
        Fate.monitorTheQueue();
    }

    private Integer taskName = 0;
    private String taskResult = "";
    private static Integer index = 0;
    // Micro and Macro Task Queue
    private static Queue<Map<Integer, Supplier<String>>> taskNameAndTaskMapQueue = new LinkedList<>();
    private static Map<Integer, String> taskNameAndTaskResultMap = new HashMap<>();

    private static synchronized Queue<Map<Integer, Supplier<String>>> getTaskNameAndTaskMapQueue() {
        return taskNameAndTaskMapQueue;
    }

    private static synchronized Map<Integer, String> getTaskNameAndTaskResultMap() {
        return taskNameAndTaskResultMap;
    }

    public Fate(Integer index) {
        this.taskName = index;
    }

    public String get() {
        // System.out.println("taskname : " + this.taskName);
        // poll
        while (true) {
            Map<Integer, String> taskNameAndTaskResultMap = Fate.getTaskNameAndTaskResultMap();
            // System.out.println("Get Map: " + taskNameAndTaskResultMap);
            if (taskNameAndTaskResultMap.containsKey(this.taskName)
                    && taskNameAndTaskResultMap.get(this.taskName) != "NULL") {
                this.taskResult = getTaskNameAndTaskResultMap().get(this.taskName);
                break;
            }
        }
        System.out.println("Get Single Name : " + this.taskName);
        System.out.println("Get Single Result : " + this.taskResult);
        return this.taskResult;
    }

    // Event Loop
    public static void monitorTheQueue() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // poll
                while (true) {
                    // System.err.println("Monitoring");
                    if (Fate.getTaskNameAndTaskMapQueue().peek() != null) {
                        Map<Integer, Supplier<String>> taskNameAndTaskMap = Fate.getTaskNameAndTaskMapQueue().poll();
                        for (Map.Entry<Integer, Supplier<String>> entry : taskNameAndTaskMap.entrySet()) {
                            Integer taskName = entry.getKey();
                            String taskResult = entry.getValue().get();
                            Fate.getTaskNameAndTaskResultMap().put(taskName, taskResult);
                            System.out.println("Thread : " + Fate.getTaskNameAndTaskResultMap());
                        }
                    }
                }
            }
        }).start();
    }

    public static Fate loadInQueue(Supplier<String> task) {
        Map<Integer, Supplier<String>> taskNameAndTaskMap = new HashMap<>();
        taskNameAndTaskMap.put(++Fate.index, task);
        Fate.getTaskNameAndTaskMapQueue().add(taskNameAndTaskMap);

        Fate.getTaskNameAndTaskResultMap().put(Fate.index, "NULL");
        // System.out.println(taskNameAndTaskMapQueue.toString());
        return new Fate(Fate.index);
    }

    // @Override
    // protected void finalize() throws Throwable {
    // try {
    // Thread.currentThread().isInterrupted();
    // thread.interrupt();
    // System.out.println("Finalizing the object");
    // // Cleanup code here
    // } finally {
    // super.finalize();
    // }
    // }
}