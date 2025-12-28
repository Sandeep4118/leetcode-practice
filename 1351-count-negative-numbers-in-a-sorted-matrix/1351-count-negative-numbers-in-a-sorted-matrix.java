class Solution {
    public int countNegatives(int[][] grid) {
        // better
        // int count = 0;
        // for(int i = 0; i<grid.length; i++){
        //     int s = 0;
        //     int e = grid[0].length -1;
        //     while(s<=e){
        //         int mid = (e+s)/2;

        //         if(grid[i][mid]>=0){
        //             s = mid + 1;
        //         }
        //         else{
        //             e = mid - 1;
        //         }
        //     }
        //     count += grid.length-s;
        // }
        // return count;


        // optimal
        int m = grid.length;
        int n = grid[0].length;
        int row = m-1;
        int col = 0;
        int count = 0;
        while(row>=0 && col<n){
            if(grid[row][col]<0){
                count += n-col;
                row--;
            }
            else{
                col++;
            }
        }
        return count;
    }
}