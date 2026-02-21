class Solution {
    public int pivotInteger(int n) {
        int T = (n*(n+1))/2;
        int start = 1;
        int end = n;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(mid*mid == T) return mid;
            else if(mid*mid < T) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}