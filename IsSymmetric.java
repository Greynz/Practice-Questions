import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by DrDan on 1/18/2017.
 */
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IsSymmetric {

    public void test(){
        TreeNode b1 = new TreeNode(0);
        TreeNode b2 = new TreeNode(3);
        TreeNode b3 = new TreeNode(0);
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
        System.out.println(isSymmetric2(t));

    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRecursion(root.left, root.right);
    }

    public boolean isSymmetricRecursion(TreeNode l, TreeNode r){
        if ((l == null && r != null) || (r== null && l!=null)) return false;
        if (l==null && r==null) return true;
        if (l.val != r.val) return false;
        if (!isSymmetricRecursion(l.left, r.right)) return false;
        if (!isSymmetricRecursion(l.right, r.left)) return false;
        return true;
    }

    public boolean isSymmetric2(TreeNode root){
        Queue<TreeNode> ql = new LinkedList<TreeNode>();
        Queue<TreeNode> qr = new LinkedList<TreeNode>();

        if (root == null) return true;

        ql.add(root.left);
        qr.add(root.right);

        while (!ql.isEmpty() && !qr.isEmpty()){
            if (ql.size() != qr.size()) return false;
            TreeNode l = ql.poll();
            TreeNode r = qr.poll();
            if ((l==null && r != null) || (l!=null && r==null)) return false;
            if (l!=null && r!=null){
                if (l.val != r.val) return false;
                if ((l.left != null && r.right ==null) || (l.left == null && r.right != null)) return false;
                if ((l.right != null && r.left ==null) || (l.right == null && r.left != null)) return false;
                if (l.left != null && r.right != null){
                    ql.add(l.left);
                    qr.add(r.right);
                }
                if (l.right != null && r.left != null){
                    ql.add(l.right);
                    qr.add(r.left);
                }
            }
        }
        return true;
    }
}
