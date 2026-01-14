class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                contains1 = true;
            }
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i] = 1;
            }
        }
        if(contains1 == false){
            return 1;
        }

        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;

            if(nums[index]<0) continue;
            else{
                nums[index] = -nums[index];
            }
        }

        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0) continue;
            else{
                return i+1;
            }
        }
        return nums.length+1;
    }
}