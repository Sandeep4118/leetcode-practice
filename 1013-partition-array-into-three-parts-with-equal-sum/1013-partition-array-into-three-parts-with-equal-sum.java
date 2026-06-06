class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int x : arr){
            sum+=x;
        }

        if(sum % 3 != 0) return false;

        int target = sum /3;
        int cursum = 0;
        int count = 0;

        for(int x : arr){
            cursum += x;
            if(cursum == target){
                count++;
                cursum = 0;
            }
        }
        return count >= 3;
    }
}