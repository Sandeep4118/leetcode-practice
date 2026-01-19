class Solution {
    public int evalRPN(String[] tokens) {
        int count = 0;
        int first = -1;
        int second = -1;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<tokens.length; i++){
                if(tokens[i].equals("+")){
                    first = st.pop();
                    second = st.pop();
                    count= first + second;
                    st.push(count);
                }
                else if(tokens[i].equals("*")){
                    first = st.pop();
                    second = st.pop();
                    count = first * second;
                    st.push(count);
                }   
                else if(tokens[i].equals("-")){
                    first = st.pop();
                    second = st.pop();
                    count = second - first;
                    st.push(count);
                }
                else if(tokens[i].equals("/")){
                    first = st.pop();
                    second = st.pop();
                    count = second / first;
                    st.push(count);
                }
            else {
                st.push(Integer.parseInt(tokens[i]));
            }
            
        }
        return st.peek();
    }
}