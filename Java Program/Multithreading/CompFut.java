import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompFut {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World");
            }
            return "Bye";
        });
        String str = f1.get();
        System.out.println(str);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(str + " World");
            }
            return "Done";
        });
        System.out.println(f2.get());
        System.out.println("Main");
    }
}