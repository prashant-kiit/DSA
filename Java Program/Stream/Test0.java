import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test0 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        Integer square = number.stream()
                .map(x -> {
                    System.out.println("Map 1 = " + x);
                    return x % 2;
                })
                .map(x -> {
                    System.out.println("Map 2 = " + x);
                    return x * 2;
                })
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .limit(2)
                .max(Comparator.comparing(Integer::valueOf))
                .map(x -> {
                    System.out.println("Map 3 = " + x);
                    return x * x;
                }).get();
        System.out.println(square);
    }
}