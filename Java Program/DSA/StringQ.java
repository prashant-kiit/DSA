/**
 * StringQ
 */
public class StringQ {
    public static void main(String[] args) {
        // String str = "chjshg";
        // String answer = new Solution().filterString(str, 0);
        // String answer = new Solution().filterStringFaster(str, 0, str.length() - 1);
        // System.out.println(answer);
        new Solution().mazePath(2, 0, 0, 1, 1, "");
    }
}

class Solution {
    String filterString(String str, int i) {
        String ans = "";
        if (i > str.length() - 1) {
            return ans;
        }
        if (str.charAt(i) != 'c' && str.charAt(i) != 'd') {
            ans = "" + str.charAt(i);
        }
        return ans + filterString(str, i + 1);
    } // O(n), O(n)

    String filterStringFaster(String str, int i, int j) {
        int mid = (i + j) / 2;
        if (i == j) {
            if (str.charAt(i) != 'c' && str.charAt(i) != 'd') {
                return "" + str.charAt(i);
            }
            return "";
        }
        return filterStringFaster(str, i, mid) + filterStringFaster(str, mid + 1, j);
    } // O(n), O(logn)

    void mazePath(int size, int x, int y, int obX, int obY, String path) {
        // home cell
        if (x == size && y == size) {
            System.out.println(path);
            return;
        }
        // obstacles
        else if( x==obX && y == obY) {
            return;
        }
        // border cells
        else if (x != size && y == size) {
            mazePath(size, x + 1, y, obX, obY, path + "D");
        }
        else if (x == size && y != size) {
            mazePath(size, x, y + 1, obX, obY, path + "R");
        }
        // remaining cells
        else {
            mazePath(size, x + 1, y, obX, obY, path + "D");
            mazePath(size, x, y + 1, obX, obY, path + "R");
            mazePath(size, x + 1, y + 1, obX, obY, path + "d");
        }
    }
}