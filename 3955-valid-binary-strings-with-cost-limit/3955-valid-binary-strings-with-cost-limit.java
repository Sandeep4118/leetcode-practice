class Solution {
    public static void recur(int idx, int prev, int cost, List<String>str,int n, String str1, int k){
        if(cost>k){
            return;
        }
        if(idx==n){
            str.add(str1);
            return;
        }

        // non-pick t o 0
        recur(idx+1,0,cost,str,n,str1+"0",k);

        // pick to 1
        if(prev != 1){
            recur(idx+1, 1, cost+idx, str,n,str1+"1",k);
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> str = new ArrayList<>();
        String str1 = "";
        recur(0,0,0,str,n,str1,k);
        return str;
    }
}