class Solution {
    public static List<List<Integer>> findtwoSum(int[] nums,int target, int i, int j){
        List<List<Integer>> add = new ArrayList<List<Integer>>();
        while(i<j){
            if(nums[i] + nums[j]>target) j--;
            else if(nums[i] + nums[j]<target)i++;
            else{
                while(i<j && nums[i] == nums[i+1])i++;
                while(i<j && nums[j] == nums[j-1])j--;
                List<Integer> arr = new ArrayList<>();
                arr.add(-target);
                arr.add(nums[i]);
                arr.add(nums[j]);
                add.add(arr);
                i++;
                j--;
            }
        }
        return add;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalresult = new ArrayList<List<Integer>>();

        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int n1 = nums[i];
            int target = -n1;

            finalresult.addAll(findtwoSum(nums,target,i+1,nums.length-1));
        }

        return finalresult;
    }
}