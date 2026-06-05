class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int []total = new int[n];
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            int cnt = 1;
            mini = Math.min(mini, items[i][1]);
            for(int j = 0; j<n; j++){
                if(i==j) continue;
                if(items[j][0]%items[i][0]==0)cnt++;
            }
            total[i] = cnt;
        }

        int[][]t = new int[n+1][budget+1];
        for(int left = 0; left<=budget; left++){
            t[n][left] = left/mini;
        }

        for(int idx = n-1; idx>=0; idx--){
            for(int left = 0; left<=budget; left++){
                int notpick = t[idx+1][left];
                int pick = 0;

                if(left>=items[idx][1]){
                    pick = total[idx] + t[idx+1][left-items[idx][1]];
                }

                t[idx][left] = Math.max(pick,notpick);
            }
        }
        return t[0][budget];
    }
}