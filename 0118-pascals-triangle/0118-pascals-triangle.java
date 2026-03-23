class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int n = 0; n<numRows; n++){
            List<Integer> row = new ArrayList<>();
            for(int r=0; r<=n; r++){
                row.add(combination(n,r));
            }
            result.add(row);
        }
        return result;
    }

    public int combination(int n, int r){
        long res = 1;
        for(int i=0; i<r; i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        return (int) res;
    }
}