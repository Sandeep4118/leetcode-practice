class Solution {
    public int minimumSwaps(int[] nums) {
        int countZ = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0)countZ++;
        }
        int nonzeros = 0;
        for(int i = nums.length-countZ; i<nums.length; i++){
            if(nums[i]!=0)nonzeros++;
        }
        return nonzeros;
    }
}