class Solution {
    public int minimumSum(int[] nums) {
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                        if((nums[i]<nums[j]) && (nums[k]<nums[j])){
                            sum = Math.min(sum,nums[i]+nums[j]+nums[k]);
                        }
                }
            }
        }
        return (sum==Integer.MAX_VALUE)?-1:sum;
    }
}