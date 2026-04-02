class Solution {
    int preIndex = 0;
    java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);

        root.left = helper(preorder, left, index - 1);
        root.right = helper(preorder, index + 1, right);

        return root;
    }
}