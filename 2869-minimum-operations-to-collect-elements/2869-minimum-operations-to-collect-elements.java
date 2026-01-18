class Solution {
    public int minOperations(List<Integer> nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i<=k; i++){
            arr.add(i);
        }

        int count = 0;
        for(int i = nums.size()-1; i>=0; i--){
            count++;

            if(arr.contains(nums.get(i))){
                arr.remove(Integer.valueOf(nums.get(i)));
            }
            if(arr.size()==0)  break;

        }
        return count;
    }
}