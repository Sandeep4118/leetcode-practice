class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length<3) return true;
        int first = arr[1] - arr[0];
        for(int i = 2; i<arr.length; i++){
            if((arr[i] - arr[i-1]) != first){
                return false;
            }
        }
        return true;
    }
}