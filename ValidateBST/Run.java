class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    static boolean dfs(long lower, long upper, TreeNode curr) {
        if (curr == null) return true;
        return (curr.val > lower && curr.val < upper) && dfs(lower, curr.val, curr.left) && dfs(curr.val, upper, curr.right);
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

public class Run {
    public static void main(String[] args) {
        
    }
}