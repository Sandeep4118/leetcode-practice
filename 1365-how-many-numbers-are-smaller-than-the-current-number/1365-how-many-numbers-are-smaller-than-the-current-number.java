class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Step 1: Frequency array
        int[] count = new int[101];   // because 0 ≤ nums[i] ≤ 100

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        // Step 2: Prefix sum
        // count[i] = how many numbers are <= i
        for (int i = 1; i < 101; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Step 3: Build answer array
        int[] newarr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                newarr[i] = 0;
            } else {
                newarr[i] = count[nums[i] - 1];
            }
        }

        return newarr;
    }
}
