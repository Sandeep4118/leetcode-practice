class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> mini = new PriorityQueue<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                mini.add(matrix[i][j]);
            }
        }
        
        int count = 1;
        int answer = 0;
        while(!mini.isEmpty()){
            if(count==k){
                answer = mini.poll();
                break;
            }
            mini.poll();
            count++;
        }
        return answer;
    }
}