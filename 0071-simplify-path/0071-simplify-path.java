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

        String[] word2 = new String[st.size()];
        for(int i = st.size()-1; i>=0; i--){
            word2[i] = st.pop();
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i<word2.length; i++){
            str.append("/");
            str.append(word2[i]);
        }
        return str.toString();
        // StringBuilder str = new StringBuilder();
        // while(!st.isEmpty()){
        //     // str.append("/");
        //     str.append(st.peek());
        //     st.pop();
        // }

        // String word1 = str.toString();
        // String [] word3 = word1.split("/");

        // int i = 0;
        // int j = word3.length-1;
        // while(i<j){
        //     String temp = word3[i];
        //     word3[i] = word3[j];
        //     word3[j] = temp;
        //     i++;
        //     j--;
        // }

        // StringBuilder str2 = new StringBuilder();
        // for(int k = 0; k<word3.length; k++){
        //     str.append("/");
        //     str.append(word3[k]);
        // }
        // return str.toString();
    }
}