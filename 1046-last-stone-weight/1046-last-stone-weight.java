class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<stones.length; i++){
            pr.add(stones[i]);
        }

        while(!pr.isEmpty()){
            if(pr.size()>1){
                int x = pr.poll();
                int y = pr.poll();

                if(x == y) continue;
                else{
                    y = Math.abs(x-y);
                    pr.add(y);
                }
            }
            else break;
        }
        return (!pr.isEmpty())?pr.poll():0;
    }
}