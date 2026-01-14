class Solution {
    public int missingNumber(int[] nums) {
        boolean contains = false;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1) contains = true;
            if(nums[i]==0 || nums[i]>nums.length){
                nums[i] = 1;
            }
        }

        if(contains == false) return 1;

        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]<0) continue;
            else{
                nums[index] = -nums[index];
            }
        }

        int missing = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0) continue;
            else{
                missing = i+1;
            }
        }
        return missing;
    }
}