class Solution {
    public boolean validDigit(int n, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int a = n;
        while(a>0){
            int temp = a %10;
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }
            else map.put(temp,1);
            a = a/10;
        }

        String b = String.valueOf(n);
        String c = String.valueOf(x);
        if(!c.startsWith(String.valueOf(b.charAt(0))) && map.containsKey(x)) return true;
        return false;
    }
}