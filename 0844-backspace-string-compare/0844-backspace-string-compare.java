class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);

            if(ch1=='#'){
                if(str1.length()>0){
                    str1.deleteCharAt(str1.length()-1);
                }
            }
            else{
                str1.append(ch1);
            }
        }

        for(int i = 0; i<t.length(); i++){
            char ch2 = t.charAt(i);

            if(ch2=='#'){
                if(str2.length()>0){
                    str2.deleteCharAt(str2.length()-1);
                }
            }
            else{
                str2.append(ch2);
            }
        }

        if(!str1.toString().equals(str2.toString())){
            return false;
        }
        return true;
    }
}