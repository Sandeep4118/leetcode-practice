class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int [] arr = new int[prices.length];
        for(int i = 0; i<prices.length; i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                int index = st.pop();
                arr[index] = prices[index] - prices[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index2 = st.pop();
            arr[index2] = prices[index2];
        }
        return arr;
    }
}