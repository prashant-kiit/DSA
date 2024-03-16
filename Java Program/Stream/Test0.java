import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> square = number.stream()
                .map(x -> {
                    System.out.println("Map 1 = " + x);
                    return x % 2;
                })
                .map(x -> {
                    System.out.println("Map 2 = " + x);
                    return x * 2;
                })
                .sorted()
                .map(x -> {
                    System.out.println("Map 3 = " + x);
                    return x * x;
                })
                .collect(Collectors.toList());
        System.out.println(square);
    }
}