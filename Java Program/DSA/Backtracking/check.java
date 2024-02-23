package Backtracking;
import java.util.Arrays;

public class check {
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        System.out.println("1 = " + Arrays.deepToString(a));
        solve(a);
        System.out.println("2 = " + Arrays.deepToString(a));
    }

    private static void solve(int[][] a) {
        System.out.println("3 = " + Arrays.deepToString(a));
        a[0][0] = 100;
        System.out.println("4 = " + Arrays.deepToString(a));
    }
}
