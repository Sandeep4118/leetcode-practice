class Solution {
    String s;
    int n;
    long[][] dpTotalNumbers  = new long[16][10 * 10];
    long[][] dpTotalWaviness = new long[16][10 * 10];
    boolean[][] visited      = new boolean[16][10 * 10];

    
    public long[] solve(int curr, int preprev, int prev, boolean isLimited, boolean isLeadingZero){
        if(curr == n){
            return new long[]{1,0};
        }

        int key = (preprev < 0 ? 0 : preprev) * 10 + (prev < 0 ? 0 : prev);

        if (!isLimited && !isLeadingZero && preprev >= 0 && prev >= 0) {
            if (visited[curr][key]) {
                return new long[]{dpTotalNumbers[curr][key], dpTotalWaviness[curr][key]};
            }
        }

        long totalNumbers = 0;
        long totalWaveScore = 0;
        int limitdigit = (isLimited) ? (s.charAt(curr) - '0') : 9;

        for(int digit = 0; digit<=limitdigit; digit++){
            boolean newIsleadingZero = (isLeadingZero && (digit==0));
            int newpreprev = prev;
            int newpre = (newIsleadingZero) ? -1 : digit;

            long result[] = solve(curr+1, newpreprev, newpre, 
                (isLimited &&(digit==limitdigit)), newIsleadingZero);
            
            long remNumber = result[0];
            long remWaveScore = result[1];

            if(!newIsleadingZero && preprev>=0 && prev>=0){
                boolean ispeak = (preprev < prev && prev > digit);
                boolean isvalley = (preprev > prev && prev < digit);

                if(ispeak || isvalley){
                    totalWaveScore += remNumber;
                }
            }

            totalNumbers += remNumber;
            totalWaveScore += remWaveScore;
        }
        if(!isLimited && !isLeadingZero && preprev >= 0 && prev >= 0) {
            dpTotalNumbers[curr][key]  = totalNumbers;
            dpTotalWaviness[curr][key] = totalWaveScore;
            visited[curr][key]         = true;
        }

        return new long[]{totalNumbers, totalWaveScore};
    }
    public long func(long nums){
        if(nums<100) return 0; // 0 to 99 are invalid numbers
        s = Long.toString(nums);
        n = s.length();

        dpTotalNumbers  = new long[16][100];
        dpTotalWaviness = new long[16][100];
        visited         = new boolean[16][100];

        long[] result = solve(0,-1,-1,true,true);
        return result[1];
    }
    public long totalWaviness(long num1, long num2) {
        return func(num2) - func(num1-1);
    }
}