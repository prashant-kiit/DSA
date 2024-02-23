public class Oracle {
    public static int count = 0;
    public static void findways(int n, int k, int sum, int total, String s) {
        if (sum > total) {
            // System.out.println("Not Ans = " +s);
            return;
        }

        if (sum == total) {
            count++;
            System.out.println("Ans = " + s);
            return;
        }

        for (int i = n; i <= k; i++) {
            findways(i, k , sum + i, total, s + i + ",");
        }
    }
    public static void main(String[] args) {
        findways(1, 3, 0, 5, "");
        System.out.println(count);
    }
}

