class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int []preffix = new int[nums.length];
        int []suffix = new int[nums.length];

        preffix[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            preffix[i] = Math.max(preffix[i-1],nums[i]);
        }

        suffix[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
            suffix[i] = Math.min(suffix[i+1], nums[i]);
        }

        for(int i = 0; i<nums.length; i++){
            if(Math.abs(preffix[i]-suffix[i])<=k) return i;
        }
        return -1;
    }
}