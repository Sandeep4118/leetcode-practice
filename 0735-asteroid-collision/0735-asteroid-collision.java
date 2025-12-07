class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i: arr){
            boolean a = false;

            while(!st.empty() && i<0 && st.peek()>0){

                if(Math.abs(st.peek())<Math.abs(i)){
                    st.pop();
                }
                else if(Math.abs(st.peek())==Math.abs(i)){
                    st.pop();
                    a = true;
                    break;
                }
                else{
                    a = true;
                    break;
                }
            }

            if(!a){
                st.push(i);
            }
        }

        int n = st.size();
        int[] arr1 = new int[n];
        for(int i = n-1; i>=0; i--){
            arr1[i] = st.pop();
        }

        return arr1;
    }
}