package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeOrderTraversal102 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level){
        if(levels.size() == level) levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if(node.left != null) helper(node.left,level+1);
        if(node.right != null) helper(node.right,level+1);
    }


    public List<List<Integer>> levelOrder2(TreeNode root){

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;

        Queue<TreeNode> myqueue = new LinkedList<TreeNode>();
        myqueue.add(root);
        int level = 0;

        while(!myqueue.isEmpty()){
            if(levels.size() == level) levels.add(new ArrayList<Integer>());

            int level_length = myqueue.size();

            for(int i = 0; i< level_length; i++){
                TreeNode node = myqueue.remove();

                levels.get(level).add(node.val);

                if(node.left != null) myqueue.add(node.left);
                if(node.right != null)  myqueue.add(node.right);
            }

            level++;
        }

        return levels;
    }

}
