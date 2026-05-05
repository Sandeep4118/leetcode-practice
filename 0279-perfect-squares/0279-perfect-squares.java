class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if((int)Math.pow(i,2)<=n){
                arr.add((int)Math.pow(i,2));
            }
        }

        int a = arr.size();
        int[][]t = new int[a+1][n+1];

        for(int i = 0; i<a+1; i++){
            for(int j = 0; j<n+1; j++){
                if(i==0)t[i][j] = Integer.MAX_VALUE - 1;
                if(j==0)t[i][j] = 0;
            }
        }

        // for 1st row 
        for(int j = 1; j<n+1; j++){
            if(arr.size()>=1){
                if(j%arr.get(0) == 0){
                    t[1][j] = j / arr.get(0);
                }
                else{
                    t[1][j] = Integer.MAX_VALUE -1;
                }
            }
        }

        // for other rows and columns 
        for(int i = 2; i<a+1; i++){
            for(int j = 1; j<n+1; j++){
                if(arr.get(i-1)<=j){
                    t[i][j] = Math.min(t[i][j-arr.get(i-1)]+1, t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[a][n] == Integer.MAX_VALUE-1 ? -1 : t[a][n];
    }
}