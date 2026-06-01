class Solution {
    public int digitFrequencyScore(int n) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int a = n;
        while(a>0){
            int temp = a % 10;

            set.add(temp);
            map.put(temp, map.getOrDefault(temp,0)+1);
            
            a = a / 10;   
        }

        int count = 0;
        for(int x : set){
            int b = x;
            int c = map.get(x);
            count += b * c;
        }
        return count;
    }
}