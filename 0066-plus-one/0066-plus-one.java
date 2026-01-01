class Solution {
    public int[] plusOne(int[] digits) {
        // Brute force

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<digits.length; i++){
            arr.add(digits[i]);
        }
        int carry = 1;
        for(int i = arr.size()-1;i>=0; i--){
            if(arr.get(i)!=9){
                arr.set(i,arr.get(i)+carry);
                carry = carry/10;;
            }
            else{
                int num = arr.get(i);
                int sum = num + carry;
                arr.set(i,sum%10);
                carry = sum/10;
            }
        }
        if(carry>0){
            arr.add(0,carry);
        }
        int [] newarr = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            newarr[i] = arr.get(i);
        }
        return newarr;

        // int carry = 1;
        // for(int i = digits.length-1; i>=0; i--){
        //     int sum = digits[i] + carry;
        //     digits[i] = sum % 10;
        //     carry = sum / 10;
        // }
        // if(carry!=0){
        //     int [] arr = new int[digits.length + 1];
        //     arr[0] = carry;
        //     return arr;
        // }
        // return  digits;

    }
}