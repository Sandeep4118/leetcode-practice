class Solution {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int k = n;
        int i = 0;
        while(i<n && k<nums.length){
            arr.add(nums[i]);
            arr.add(nums[k]);
            i++;
            k++;
        }

        int[] arr1 = new int[nums.length];
        for(int j = 0;j<arr1.length; j++){
            arr1[j] = arr.get(j);
        }
        return arr1;

    }
}