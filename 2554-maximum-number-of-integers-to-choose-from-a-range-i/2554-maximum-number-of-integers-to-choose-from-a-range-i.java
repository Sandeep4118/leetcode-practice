class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<banned.length; i++){
            int value = map.getOrDefault(banned[i],0);
            map.put(banned[i],value+1);
        }

        int sum = 0;
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(!map.containsKey(i)){
                sum+=i;
                count++;

                if(sum>maxSum){
                    sum-=i;
                    count--;
                }
            }
        }
        return count;
    }
}