class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> current, List<List<Integer>> result){
        if(k == 0 && target == 0){
            result.add(new ArrayList<>(current));
        }

        for(int i = start; i <= 9; i++){
            if(i > target)break;

            current.add(i);
            backtrack(i + 1, k - 1, target - i, current, result);
            current.remove(current.size() - 1);
        }
    }
}