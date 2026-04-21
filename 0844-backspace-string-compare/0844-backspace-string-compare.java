class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);

            if(ch1 == '#'){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(ch1);
            }
        }

        for(int i = 0; i<t.length(); i++){
            char ch2 = t.charAt(i);

            if(ch2 == '#'){
                if(!st2.isEmpty()){
                    st2.pop();
                }
            }
            else{
                st2.push(ch2);
            }
        }

        // StringBuilder 
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while(!st1.isEmpty()){
            str1.append(st1.pop());
        }
        while(!st2.isEmpty()){
            str2.append(st2.pop());
        }

        if(!str1.toString().equals(str2.toString())) return false;
        return true;
    }
}