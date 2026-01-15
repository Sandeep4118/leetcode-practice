class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        long cur = 1;
        for(int i = 0; i<nums.length; i++){
            if(k==0) break;

            if(nums[i]< cur){
                continue;
            }

            if(nums[i]> cur){
                long gap = nums[i] - cur;
                long take = Math.min(k,gap);

                long l = cur;
                long r = cur + (take - 1);

                sum += (l + r)*take/2;
                k-=take;
            }
            cur = nums[i] + 1;
        }

        if(k>0){
            long l = cur;
            long r = cur + k - 1;
            sum += (l+r)*k/2;
        }
        return sum;
    }
}