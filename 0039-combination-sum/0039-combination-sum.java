class Solution {
    public static void solve(int i, int []candidates, int target, List<List<Integer>> result, List<Integer> list){
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(target<0 || i>= candidates.length) return;
        // add element to the list and then take it 
        list.add(candidates[i]);
        solve(i,candidates, target-candidates[i], result, list);
        list.remove(list.size()-1);

        // not take 
        solve(i+1,candidates, target, result, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        solve(0,candidates, target, result, list);
        return result;
    }
}