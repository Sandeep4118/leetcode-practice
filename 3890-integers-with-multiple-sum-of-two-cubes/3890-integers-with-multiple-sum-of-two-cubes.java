class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int limit = (int)Math.cbrt(n);

        for(int i = 1; i<=limit; i++){
            int a = (int)Math.pow(i,3);
            for(int j = i; j<=limit; j++){
                int b = (int)Math.pow(j,3);
                int sum = a + b;
                if(sum<=n && map.containsKey(sum)){
                    map.put(sum,map.get(sum) + 1);
                }
                else{
                    map.put(sum,1);
                }
            }
        }


        List<Integer> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue()>=2){
                arr.add(it.getKey());
            }
        }
        Collections.sort(arr);
        return arr;
    }
}