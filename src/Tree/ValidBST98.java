package Tree;

public class ValidBST98 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper){

        if (node == null) return true;

        if (upper != null && node.val >= upper) return false;
        if (lower != null && node.val <= lower) return false;
        if (!helper(node.left, lower, node.val)) return false;
        if (!helper(node.right, node.val, upper)) return false;
        return true;
    }
}
