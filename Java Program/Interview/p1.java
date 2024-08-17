public class p1 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        int n = 6;
        String codedStr = "";
        int length = str.length();
        int efflen = length / n * n;
        for (int i = 0; i <= efflen - n; i += n) {
            String substring = str.substring(i, i + n);
            String reverseSubString = reverse(substring);
            codedStr = codedStr + reverseSubString;
        }
        String left = str.substring(efflen, length);
        String reverseLeft = reverse(left);
        codedStr = codedStr + reverseLeft;
        System.out.println(codedStr);
    }

    private static String reverse(String substring) {
        String reverseSubString = "";
        for (int i = substring.length() - 1; i >= 0; i--) {
            reverseSubString = reverseSubString + substring.charAt(i);
        }
        System.out.println(reverseSubString);
        return reverseSubString;
    }
}
