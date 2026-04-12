class Solution {
    public double[] internalAngles(int[] sides) {
        double []angle = new double[sides.length];
        
        if((sides[0] + sides[1]>sides[2]) && (sides[1] + sides[2] > sides[0]) && (sides[2] + sides[0] > sides[1])){

            int a = sides[0];
            int b = sides[1];
            int c = sides[2];
            // for A side
            double cosA = (Math.pow(b,2) + Math.pow(c,2) - Math.pow(a,2))/(2*b*c);

            double A = Math.acos(cosA);
            angle[0] = Math.toDegrees(A);

            // for B side
            double cosB = (Math.pow(a,2) + Math.pow(c,2) - 
Math.pow(b,2))/(2*a*c);

            double B = Math.acos(cosB);
            angle[1] = Math.toDegrees(B);


            // for C side
            double cosc = (Math.pow(a,2) + Math.pow(b,2) - 
Math.pow(c,2))/(2*a*b);

            double C = Math.acos(cosc);
            angle[2] = Math.toDegrees(C);
        }
        else return new double[0];
        Arrays.sort(angle);
        return angle;
    }
}