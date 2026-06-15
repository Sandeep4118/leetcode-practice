class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // overlap case
        int overlapheigh = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int overlapwidht = Math.min(ay2,by2) - Math.max(ay1,by1);

        int area = 0;
        if(overlapheigh<=0 || overlapwidht<=0){
            area = 0;
        }
        else{
            area = overlapheigh * overlapwidht;
        }

        // normal area 
        int first = Math.abs(ax2-ax1) * Math.abs(ay2-ay1);

        int second = Math.abs(bx2-bx1) * Math.abs(by2-by1);

        return first + second - area;
    }
}