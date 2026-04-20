class Solution {
    public int subsetSum(int []nums, int s1){
        int n = nums.length;
        int[][] t = new int[n+1][s1+1];

        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<s1+1; j++){
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<s1+1; j++){
                if(nums[i-1]<=j){
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][s1];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }  

        int s1 = (sum+target)/2;

        if((sum+target)%2!=0 || (sum+target)<0) return 0;

        return subsetSum(nums,s1);
    }
}