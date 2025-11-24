class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> str = new ArrayList<>();
        int num = 0;
        for(int i : nums){
            num = (num * 2 + i)%5;
            if(num==0){
                str.add(true);
            }
            else{
                str.add(false);
            }
        }
        return str;
    }
}