class Solution {
    public static void func(int i,ArrayList<Integer> arr, List<List<Integer>> result, ArrayList<Integer> list, int k ,int n){
        if(list.size()==k && n==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i>=arr.size() || list.size()>k || n<0) return;

        list.add(arr.get(i));
        func(i+1,arr,result,list,k,n-arr.get(i));
        list.remove(list.size()-1);

        func(i+1,arr,result,list,k,n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        func(0,arr,result,list,k,n);
        return result;
    }
}