class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][]t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                if(i==0)t[i][j] = 0;
                if(j==0)t[i][j] = 0;
            }
        }

        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(word1.charAt(i-1) == word2.charAt(j-1)){
                str.append(word1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(t[i-1][j] > t[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        String result = str.reverse().toString();
        int a = Math.abs(word1.length() - result.length());
        int b = Math.abs(word2.length() - result.length());
        return a + b;
    }
}