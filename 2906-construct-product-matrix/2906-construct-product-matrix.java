class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] flat = new int[m*n];
        int prod = 12345;

        int k = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                flat[k] = grid[i][j];
                k++;
            }
        }

        // prefix product 
        long[] prefix = new long[flat.length];
        prefix[0] = 1;
        for(int i = 1; i<flat.length; i++){
            prefix[i] = (flat[i-1] * prefix[i-1]) % prod;
        }

        // suffix product
        long[] suffix = new long[flat.length];
        suffix[flat.length-1] = 1;
        for(int i = flat.length-2; i>=0; i--){
            suffix[i] = (flat[i+1] * suffix[i+1]) % prod;
        }

        for(int i = 0; i<flat.length; i++){
            flat[i] = (int)(prefix[i] * suffix[i]) % prod;
        }

        int a = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                grid[i][j] = flat[a];
                a++;
            }
        }
        return grid;
    }
}