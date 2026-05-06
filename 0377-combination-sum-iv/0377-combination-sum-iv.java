class Solution {
    public static int solve(int[]nums, int target, int index, int[][]t){
        if(target==0) return 1;
        if(target< 0 || index == nums.length) return 0;
        if(t[index][target] != -1) return t[index][target];

        int take = solve(nums, target-nums[index],0,t);
        int not_take = solve(nums, target,index+1,t);

        return t[index][target] = take + not_take;
    }
    public int combinationSum4(int[] nums, int target) {
        int[][] t = new int[201][1001];
        for(int i = 0; i<nums.length; i++){
            Arrays.fill(t[i],-1);
        }
        return solve(nums,target,0,t);
    }
}