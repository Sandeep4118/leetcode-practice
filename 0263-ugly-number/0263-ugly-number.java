class Solution {
    public boolean isUgly(int n) {
        int a = n;
        while(a>0){
            if(a%2==0){
                a = a/2;
            }
            else{
                if(a%3==0){
                    a = a/3;
                }
                else{
                    if(a%5==0){
                        a = a/5;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        if(a == 1) return true;
        return false;
    }
}