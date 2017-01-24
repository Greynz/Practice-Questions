import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by DrDan on 1/24/2017.
 */
public class BinaryTreeNonRecursiveTraversal {

    public void test(){

        TreeNode b1 = new TreeNode(6);
        TreeNode b2 = new TreeNode(5);
        TreeNode b3 = new TreeNode(4);
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

        System.out.println(inorderTraversal(t));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        if (root==null) return l;

        Stack<TreeNode> st = new Stack<>();
        TreeNode n = root;

        while(n != null || !st.isEmpty()){
            while(n!=null){
                st.push(n);
                n = n.left;
            }
            n = st.pop();
            l.add(n.val);
            n = n.right;
        }
        return l;
    }
}
