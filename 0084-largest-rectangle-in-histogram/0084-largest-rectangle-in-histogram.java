class Solution {
    public static int[] nextSmallerElement(int[] heights, int h){
        int [] next1 = new int[heights.length];
        Arrays.fill(next1,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int index = st.pop();
                next1[index] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            next1[st.pop()] = heights.length;
        }

        return next1;
    }

    public static int[] previousSmallerElement(int[] heights, int h){
        int [] prev1 = new int[heights.length];
        Arrays.fill(prev1,-1);
        Stack<Integer> st1 = new Stack<>();
        for(int i = 0; i<heights.length; i++){
            while(!st1.isEmpty() && heights[st1.peek()]>=heights[i]){
                int index1 = st1.pop();
            }

            if(!st1.isEmpty()){
                prev1[i] = st1.peek();
            }
            st1.push(i);
        }
        return prev1;
    }

    public int largestRectangleArea(int[] heights) {
        int h = heights.length;
        int[] next = new int[h];
        next = nextSmallerElement(heights, h);

        int[] prev = new int[h];
        prev = previousSmallerElement(heights, h);

        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<heights.length; i++){
            int length = heights[i];
            int breath = next[i] - prev[i] - 1;

            maxi = Math.max(maxi, length * breath);
        }
        return maxi;
    }
}