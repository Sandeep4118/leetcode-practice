class Solution {
    public static void func(boolean []map,List<Integer> arr, List<List<Integer>> list, int n,int[]nums){
        if(arr.size()==n){
            list.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i<n; i++){
            if(!map[i]){
                map[i] = true;
                arr.add(nums[i]);
                func(map,arr,list,n,nums);
                arr.remove(arr.size()-1);
                map[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean []map = new boolean[nums.length];

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();
        func(map,arr,list,n,nums);
        return list;
    }
}