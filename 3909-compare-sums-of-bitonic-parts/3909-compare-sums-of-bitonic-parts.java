class Solution {
    public int compareBitonicSums(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high - low)/2;

            if(nums[mid]<nums[mid+1]){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        int peak = low;

        long ascend = 0;
        for(int i = 0; i<=peak; i++){
            ascend += nums[i];
        }

        long descind = 0;
        for(int i = peak; i<nums.length; i++){
            descind += nums[i];
        }

        if(ascend>descind) return 0;
        else if(descind>ascend) return 1;
        return -1;
    }
}