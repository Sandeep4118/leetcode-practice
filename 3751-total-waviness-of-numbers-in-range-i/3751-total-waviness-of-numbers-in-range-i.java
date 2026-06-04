class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1; i<=num2; i++){
            String str = String.valueOf(i);
                if(str.length()>=3){
                for(int j = 1; j<str.length()-1; j++){
                    int first = str.charAt(j-1) - '0';
                    int second = str.charAt(j) - '0';
                    int third = str.charAt(j+1) - '0';


                    // peak 
                    if(second > first && second > third) count++;
                    // valleys
                    if(second<first && second < third) count++;
                }
            }
        }
        return count;
    }
}