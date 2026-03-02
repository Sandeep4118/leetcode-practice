class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        int totalLength = 0;
        int a = k;

        while(a>0){
            remainder = (remainder*10+1)%k;
            totalLength++;
            a--;
            
            if(remainder==0) return totalLength;
        }
        return -1;
    }
}