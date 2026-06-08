class Solution {
    public int passwordStrength(String password) {
        HashMap<Character,Integer> map = new HashMap<>();
        // for smaller case
        for(int i = 97; i<=122; i++){
            char c = (char)i;
            map.put(c,1);
        }
        // for uppercase 
        for(int i = 65; i<=90; i++){
            char c = (char)i;
            map.put(c,2);
        }

        for(char c = '0'; c<='9'; c++){
            map.put(c,3);
        }
        map.put('!',5);
        map.put('@',5);
        map.put('#',5);
        map.put('$',5);

        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<password.length(); i++){
            char c = password.charAt(i);
            set.add(c);
        }

        int sum = 0;
        for(char c : set){
            sum+=map.get(c);
        }
        return sum;
    }
}