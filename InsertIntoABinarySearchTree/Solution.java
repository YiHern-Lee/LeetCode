class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    public TreeNode insert(TreeNode T, int v) {
        if (T == null) return new TreeNode(v);
        if (T.val < v) T.right = insert(T.right, v);
        else T.left = insert(T.left, v);
        return T;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}