package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//add root into stack 1
//do the loop:
//stack 1 pop, put into the ArrayList, its children pushed into stack 2 from left to right until stack 1 is empty
//stack 2 pop, put into the ArrayList, its children pushed into stack 1 from right to left until stack 2 is empty

//stop when all two stacks are empty

public class BinaryTreeZigZagTraversal102 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();          //declare two stacks

        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if(root == null) return levels;
        st1.push(root);                                //add root into stack 1
        int level = 0;
        while((!st1.isEmpty()) || (!st2.isEmpty())){      //while one of them is nonempty

            while(!st1.isEmpty()){                 //if stack 1 is nonempty
                TreeNode node = st1.pop();                                    //pop the stack 1
                if(node != null &&node.left != null) st2.push(node.left);               //push the left child of popped node into stack 2
                if(node != null && node.right != null) st2.push(node.right);            //push the right child of popped node into stack 2
                if(levels.size() == level){
                    levels.add(new ArrayList<Integer>());
                }
                levels.get(level).add(node.val);               //add popped node into levels
            }

            level += 1;          //add one level

            while(!st2.isEmpty()){                      //while stack 2 is nonempty
                TreeNode node = st2.pop();              //pop the stack 2
                if(node != null &&node.right != null) st1.push(node.right);                       //push the right child of the popped node into stack 1
                if(node != null &&node.left != null) st1.push(node.left);                      //push the left child of the popped node into stack 1
                if(levels.size() == level){
                    levels.add(new ArrayList<Integer>());
                }
                levels.get(level).add(node.val);    //add popped node into levels

            }
            level += 1;             //add one level
        }

        return levels;

    }
}
