class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int finalsum = 0;
        for(char ch : map.keySet()){
            // ch = s.charAt(i);
            char mirror;
            if(Character.isLetter(ch)){
                mirror = (char)('z' - (ch - 'a'));
            }
            else{
                mirror = (char)('9' - (ch - '0'));
            }

            if(ch<=mirror || !map.containsKey(mirror)){
                finalsum += Math.abs(map.get(ch) - map.getOrDefault(mirror,0));
                
            }
        }
        return finalsum;
    }
}