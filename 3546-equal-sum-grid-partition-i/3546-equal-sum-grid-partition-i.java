class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rowsum = new long[m];
        long[] colsum = new long[n];

        long totalsum = 0;
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                rowsum[i] += grid[i][j];
                colsum[j] += grid[i][j];
                totalsum += grid[i][j];
            }
        }

        if(totalsum%2!=0) return false;

        // Horizontal wise
        long upper = 0;
        for(int i = 0; i<m-1; i++){
            upper += rowsum[i];
            if(upper == totalsum - upper) return true;
        }

        // vertical wise

        long left = 0;
        for(int i = 0; i<n-1; i++){
            left += colsum[i];
            if(left == totalsum-left) return true;
        }

        return false;
    }
}