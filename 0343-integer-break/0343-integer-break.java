class Solution {
    public static int solve(int n, int []t){
        if(t[n] != -1) return t[n];
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<n;i++){
            ans = Math.max(ans, Math.max(i*(n-i), i*solve(n-i,t)));
        }
        return t[n] = ans;
    }
    public int integerBreak(int n) {
        int [] t = new int[n+1];
        for(int i = 0; i<t.length; i++){
            t[i] = -1;
        }
        return solve(n,t);
    }
}