class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int index = st.pop();
                arr[index] = i - index;
            }
            st.push(i);
        }
        return arr;
    }
}