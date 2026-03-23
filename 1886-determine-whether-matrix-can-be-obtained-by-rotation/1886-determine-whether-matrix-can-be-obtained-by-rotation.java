class Solution {
    public static boolean check(int[][]mat, int[][]target){
        int n = mat.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }

    public static void rotate(int [][]mat){
        int n = mat.length;
        // transpose
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n/2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[0].length - j - 1];
                mat[i][mat[0].length-j-1] = temp;
            }
        }

        // update the mat with res

        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<n; j++){
        //         mat[i][j] = res[i][j];
        //     }
        // }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i<4; i++){
            if(check(mat,target)){
                return true;
            }
            else rotate(mat);
        }   
        return false;
    }
}