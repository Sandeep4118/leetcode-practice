class Solution {
    public int findDuplicate(int[] nums) {
        int [] arr = new int[nums.length + 1];
        for(int i = 0; i<nums.length; i++){
            arr[nums[i]]++;
        }

        int duplicate = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>1) duplicate = i;
            else continue;
        }
        return duplicate;
    }
}