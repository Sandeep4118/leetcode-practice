class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pr = new PriorityQueue<>((a,b)->b[2]-a[2]);
        for(int i = 0; i<nums1.length; i++){
            for(int j = 0; j<nums2.length; j++){
                int sum = nums1[i] + nums2[j];

                if(pr.size()<k){
                    pr.add(new int[]{nums1[i],nums2[j],sum});
                }
                else if(pr.peek()[2]>sum){
                    pr.poll();
                    pr.add(new int[]{nums1[i],nums2[j],sum});
                }
                else{
                    break;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(!pr.isEmpty()){
            int[] arr = pr.poll();
            List<Integer> answer = new ArrayList<>();
            answer.add(arr[0]);
            answer.add(arr[1]);
            result.add(answer);
        }
        return result;
    }
}