class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // creating a 2d hashset
        Set<Integer> [][] dp = new HashSet[m][n];


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = new HashSet<>();
            }
        }

        // Add 1st cell of the grid
        dp[0][0].add(grid[0][0]);

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                for(int xOrval : dp[i][j]){
                    if(j+1 <n){
                        dp[i][j+1].add(xOrval ^ grid[i][j+1]);
                    }
                    if(i+1<m){
                        dp[i+1][j].add(xOrval ^ grid[i+1][j]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int val : dp[m-1][n-1]){
            ans = Math.min(ans, val);
        }
        return ans;
    }
}