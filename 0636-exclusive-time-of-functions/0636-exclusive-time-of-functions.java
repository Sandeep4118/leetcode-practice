class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] arr = new int[n];
        Stack<Integer> st = new Stack<>();

        int timeLine = 0;

        for(int i = 0; i<logs.size(); i++){
            String [] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            String type = log[1];
            int time = Integer.parseInt(log[2]);


            if((type).equals("start")){
                if(!st.isEmpty()){
                    arr[st.peek()] += time - timeLine;
                }
                st.push(id);
                timeLine = time;
            }
            else{
                arr[st.peek()] += time - timeLine + 1;
                st.pop();
                timeLine = time + 1;
            }
        }
        return arr;
    }
}