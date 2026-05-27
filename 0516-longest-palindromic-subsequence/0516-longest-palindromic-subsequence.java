class Solution {
    public int longestPalindromeSubseq(String s) {
        // String s2 = new StringBuilder(s).reverse().toString();
        String s2 = "";
        for(int i = s.length()-1; i>=0; i--){
            s2+=s.charAt(i);
        }

        // s = agbcba
        // s2 = abcbga

        int m = s.length();
        int n = s2.length();

        int[][]t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                if(i==0)t[i][j] = 0;
                if(j==0)t[i][j] = 0;
            }
        }

        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}