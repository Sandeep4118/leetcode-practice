class Solution {
    public static void func(boolean[] map, StringBuilder str2, List<String> list, int n){
        if(str2.length()==n){
            list.add(str2.toString());
            return;
        }

        for(int i = 1; i<=n; i++){
            if(!map[i]){
                map[i] = true;
                str2.append(i);
                func(map,str2,list,n);
                str2.deleteCharAt(str2.length()-1);
                map[i] = false;
            }
        }
    }
    public String getPermutation(int n, int k) {
        boolean []map = new boolean[n+1];
        StringBuilder str2 = new StringBuilder();
        List<String> list = new ArrayList<>();

        func(map,str2,list,n);

        return list.get(k-1);
    }
}