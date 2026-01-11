class Solution {
    public int[] findErrorNums(int[] nums) {
        // int[] arr = new int[nums.length+1];
        // for(int i = 0; i<nums.length; i++)
        // {
        //     arr[nums[i]]++;
        // }
        // int duplicate = 0;
        // int missing = 0;

        // for(int i = 1; i<=nums.length; i++){
        //     if(arr[i]==2){
        //         duplicate = i;
        //     }
        //     else if(arr[i]==0){
        //         missing = i;
        //     }
        // }
        // return new int[]{duplicate, missing};
        int duplicate = 0;
        int missing = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i],value+1);
        }

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() == 2){
                duplicate = it.getKey();
            }
        }

        // int k = 0;
        for(int i = 1; i<=nums.length; i++){
            if(map.containsKey(i))continue;
            else{
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}
