class Solution {
    public List<List<Integer>> findtwoSum(int [] nums,int target,int n1, int n2, int i, int j){
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        while(i<j){
            long sum = (long)n1 + n2 + nums[i] + nums[j];
            if(sum<target) i++;
            else if(sum>target) j--;
            else{
                while(i<j && nums[i]==nums[i+1])i++;
                while(i<j && nums[j]==nums[j-1])j--;
                List<Integer>arr2 = new ArrayList<>();
                arr2.add(n1);
                arr2.add(n2);
                arr2.add(nums[i]);
                arr2.add(nums[j]);
                arr.add(arr2);
                i++;
                j--;
            }
        }
        return arr;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> finalresult = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])continue;

            int n1 = nums[i];
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int n2 = nums[j];
                finalresult.addAll(findtwoSum(nums,target,n1,n2,j+1,nums.length-1));
            }
        }
        return finalresult;
    }
}