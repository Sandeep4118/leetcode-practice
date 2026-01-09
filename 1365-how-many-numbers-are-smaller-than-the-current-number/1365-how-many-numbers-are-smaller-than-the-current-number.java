class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // int[] arr = new int[nums.length];
        // for(int i = 0; i<nums.length; i++){
        //     int count = 0;
        //     for(int j = 0; j<nums.length; j++){
        //         if(nums[j]<nums[i]){
        //             count++;
        //         }
        //     }
        //     arr[i] = count;
        // }
        // return arr;

        int[] count = new int[101];
        for(int i = 0; i<nums.length; i++){
            count[nums[i]]++;
        }        

        // count[0] = 0;
        for(int i = 1; i<count.length; i++){
            count[i] = count[i] + count[i-1];
        }

        int[] newarr = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0) newarr[i] = 0;
            else newarr[i] = count[nums[i] - 1];
        }
        return newarr;
    }
}