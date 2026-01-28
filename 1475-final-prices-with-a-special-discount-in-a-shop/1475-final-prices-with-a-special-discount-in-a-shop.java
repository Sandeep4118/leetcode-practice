class Solution {
    public int[] finalPrices(int[] prices) {
        // for(int i = 0; i<prices.length; i++){
        //     for(int j = i+1; j<prices.length; j++){
        //         if(j>i && prices[j]<= prices[i]){
        //             prices[i] = Math.abs(prices[j]-prices[i]);
        //             break;
        //         }
        //     }
        // }
        // return prices;


        int [] result = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<prices.length; i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                int index = st.pop();
                result[index] = prices[index] - prices[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index2 = st.pop();
            result[index2] = prices[index2];
        }
        return result;
    }
}