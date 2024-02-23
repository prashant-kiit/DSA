class Solution {
    public int[] singleNumber(int[] nums) {
        int pair = 0;

        for (int i = 1; i < nums.length; i++) {
            pair = pair ^ nums[i];
        }

        int separator = pair & (~(pair - 1));
        int a = 0, b = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & separator) == 0) {
                a = a ^ nums[i];
            }
            else {
                b = b ^ nums[i];
            }
        }

        int[] result = {0, 0};
        result[0] = a;
        result[1] = b;

        return result;
    }
}