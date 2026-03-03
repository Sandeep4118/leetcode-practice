class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> arr = new ArrayList<>();
        for(int i = left; i<=right; i++){
            int a = i;
            int remainder = 0;
            while(a>0){
                remainder = a%10;
                if(remainder==0 || i%remainder!=0) break;
                else{
                    a = a/10;
                    if(a==0){
                        arr.add(i);
                    }
                }
            }
        }
        return arr;
    }
}