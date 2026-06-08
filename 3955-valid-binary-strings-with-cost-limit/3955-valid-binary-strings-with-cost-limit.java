class Solution {
    public static void recur(int index, int prev, int cost, List<String> result, String str, int n, int k){
        if(cost>k)return;
        if(index==n){
            result.add(str);
            return;
        }

        // take a 0 means non-pick;
        recur(index+1,0,cost,result, str+"0",n,k);

        // take a 1 means pick
        if(prev != 1){
            recur(index+1,1,cost+index,result, str+"1",n,k);
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        String str = "";
        recur(0,0,0,result,str,n,k);
        return result;
    }
}