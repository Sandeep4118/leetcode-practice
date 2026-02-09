class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // Queue<Integer> q = new LinkedList<>();
        // for(int i = 0; i<students.length; i++){
        //     q.offer(students[i]);
        // }

        // Stack<Integer> st = new Stack<>();
        // for(int i = sandwiches.length-1; i>=0; i--){
        //     st.push(sandwiches[i]);
        // }

        // int count = 0;
        // while(!q.isEmpty()){
        //     if(count == q.size()) break;

        //     if(st.peek().equals(q.peek())){
        //         st.pop();
        //         q.poll();
        //         count = 0;
        //     }
        //     else{
        //         q.offer(q.poll());
        //         count++;
        //     }
        // }
        // return count;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<students.length; i++){
            int value = map.getOrDefault(students[i],0);
            map.put(students[i],value+1);
        }
        
        for(int i = 0; i<sandwiches.length; i++){
            int type = sandwiches[i];

            if(map.getOrDefault(type,0)!=0){
                map.put(type,map.get(type)-1);
            }
            else{
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}