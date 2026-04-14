class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
            else continue;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int maxLen = 0;
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];

            int rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(len,maxLen);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}