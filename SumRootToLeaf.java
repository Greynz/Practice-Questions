/**
 * Created by DrDan on 1/20/2017.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 */

public class SumRootToLeaf {
    public void test(){
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(3);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(3);
        TreeNode m1 = new TreeNode(2);
        TreeNode m2 = new TreeNode(2);
        TreeNode t = new TreeNode(1);

        t.left = m1;
        t.right = m2;
        m1.left = b1;
        m1.right = b2;
        m2.left = b3;
        m2.right = b4;
        System.out.println(sumNumbers(t));
    }
    public int sumNumbers(TreeNode root) {
        return traverseNodes(root, 0);
    }

    public int traverseNodes(TreeNode root, int tsum){
        if (root == null) return 0;
        tsum *= 10;
        tsum += root.val;
        if (root.left == null && root.right == null) {
            return tsum;
        }
        return traverseNodes(root.left, tsum) + traverseNodes(root.right, tsum);
    }
}
