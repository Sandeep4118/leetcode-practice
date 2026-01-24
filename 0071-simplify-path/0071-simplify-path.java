class Solution {
    public String simplifyPath(String path) {
        String[] word = path.split("/");

        Stack<String> st = new Stack<>();
        for(int i = 0; i<word.length; i++){
            if(word[i].equals(".") || word[i].equals("")) continue;
            if(word[i].equals("..")){
                if(!st.isEmpty())
                st.pop();
                else continue;
            }
            else{
                st.push(word[i]);
            }
        }
        if(st.isEmpty())return "/";

        // String[] word2 = new String[st.size()];
        // for(int i = st.size()-1; i>=0; i--){
        //     word2[i] = st.pop();
        // }

        // StringBuilder str = new StringBuilder();
        // for(int i = 0; i<word2.length; i++){
        //     str.append("/");
        //     str.append(word2[i]);
        // }
        // return str.toString();

        Stack<String> st2 = new Stack<>();
        while(!st.isEmpty()){
            st2.push(st.pop());
        }

        StringBuilder str = new StringBuilder();
        while(!st2.isEmpty()){
            str.append("/").append(st2.pop());
        }
        return str.toString();
    }
}