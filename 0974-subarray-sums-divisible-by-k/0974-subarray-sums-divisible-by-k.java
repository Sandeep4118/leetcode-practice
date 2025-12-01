class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // int count = 0;
        // for(int i = 0; i<nums.length; i++){
        //     int sum = 0;
        //     for(int j = i; j<nums.length; j++){
        //         sum+=nums[j];

        //         if(sum%k==0){
        //             count++;
        //         }
        //     }
        // }   
        // return count;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            int r = sum%k;

            if(r<0){
                r = r%k + k;
            }
            
            if(map.containsKey(r)){
                count+= map.get(r);
                map.put(r,map.get(r)+1);
            }
            else{
                map.put(r,1);
            }
        }
        return count;
    }
}