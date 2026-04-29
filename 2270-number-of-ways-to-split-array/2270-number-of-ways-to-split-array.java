class Solution {
    public int waysToSplitArray(int[] nums) {
        // long sum = 0;
        // for(int i = 0; i<nums.length; i++){
        //     sum+=nums[i];
        // }

        // long leftsum = 0;
        // long rightsum = 0;
        // int count = 0;
        // for(int i = 0; i<nums.length-1; i++){
        //     leftsum+=nums[i];
        //     rightsum = sum-leftsum;
        //     if(leftsum>=rightsum)count++;
        // }
        // return count;

        long[]prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            prefix[i] = nums[i]+prefix[i-1];
        }
        long count = 0;
        for(int i = 0; i<nums.length-1; i++){
            long leftsum = prefix[i];
            long rightsum = prefix[nums.length-1] - prefix[i];
            if(leftsum >= rightsum) count++;
        }
        return (int)count;
    }
}