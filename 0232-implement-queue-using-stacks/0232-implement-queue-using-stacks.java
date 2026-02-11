class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    // int a = -1;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        // if(input.isEmpty()) a = x;
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty()) {
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        int val = output.pop();
        return val;
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */