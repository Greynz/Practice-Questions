/**
 * Created by DrDan on 2/12/2017.
 */
public class LowestCommonAncestor {

    public void test(){

        TreeNode r = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);

        r.left = n1;
        r.right = n4;
        n1.left = n2;
        n1.right = n3;
        n4.left = n5;
        n4.right = n6;

        System.out.println(lowestCommonAncestor(r, n4, n6).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        return root;

    }

}
