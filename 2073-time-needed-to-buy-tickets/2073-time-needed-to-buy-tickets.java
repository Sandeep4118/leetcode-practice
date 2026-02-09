class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<tickets.length; i++){
            q.offer(new int[]{i,tickets[i]});
        }

        int time = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int first = cur[0];
            int second = cur[1];

            time++;
            second--;

            if(first==k && second==0) break;
            if(second>0){
                q.offer(new int[]{first,second});
            }
        }
        return time;
    }
}