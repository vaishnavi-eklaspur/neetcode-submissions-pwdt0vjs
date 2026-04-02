class Solution {
    public java.util.List<java.util.List<Integer>> combinationSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        backtrack(nums, target, 0, new java.util.ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int target, int start,
                           java.util.List<Integer> curr,
                           java.util.List<java.util.List<Integer>> res) {
        if (target == 0) {
            res.add(new java.util.ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;

            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}