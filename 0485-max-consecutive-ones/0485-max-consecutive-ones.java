class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int count = 0;
       int j = -1;
       for(int i = 0; i<nums.length; i++){
           if(nums[i] == 0){
                j=i;
           }
           count = Math.max(count, i-j);
       } 
       return count;
    }
}