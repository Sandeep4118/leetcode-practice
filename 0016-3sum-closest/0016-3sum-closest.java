class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closetSum = 0;

        for(int i = 0; i<nums.length-2; i++){
            int n1 = nums[i];

            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = n1 + nums[left] + nums[right];

                int diff = Math.abs(sum - target);

                if(diff<minDiff){
                    minDiff = diff;
                    closetSum = sum;
                }

                if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return closetSum;
    }
}