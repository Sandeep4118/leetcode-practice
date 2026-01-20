class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int c = 0;
        int a = 0;
        int b = 0;

        for(int i = 0; i<operations.length; i++){
            if(operations[i].equals("D")){
                st.push(2*st.peek());
            }
            else if(operations[i].equals("C")){
                st.pop();
            }
            else if(operations[i].equals("+")){
                a = st.peek();
                st.pop();
                b = st.peek();
                st.pop();

                c = a + b;
                st.push(b);
                st.push(a);
                st.push(c);
            }
            else{
                st.push(Integer.valueOf(operations[i]));
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.peek();
            st.pop();
        }
        return sum;
    }
}