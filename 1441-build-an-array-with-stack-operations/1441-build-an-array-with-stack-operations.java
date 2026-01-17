class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> str = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i<target.length; i++){
            int value = map.getOrDefault(target[i],0);
            map.put(target[i],value+1);
        }


        for(int i = 1; i<=n; i++){
            st.push(i);
            str.add("Push");

            if(!map.containsKey(i)){
                st.pop();
                str.add("Pop");
            }


            boolean match = true;

            if(st.size() != target.length){
                match = false;
            }
            else{
                for(int j = 0; j<target.length; j++){
                    if(st.get(j) != target[j]){
                        match = false;
                        break;
                    }
                }
            }


            if(match == true){
                break;
            }
            
        }
        return str;
    }
}