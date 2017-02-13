import java.util.ArrayList;
import java.util.List;

/**
 * Created by DrDan on 1/27/2017.
 */
public class PathSum {

    public void test(){
        TreeNode b1 = new TreeNode(9);
        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(11);
        TreeNode b4 = new TreeNode(13);

        TreeNode m1 = new TreeNode(8);
        TreeNode m2 = new TreeNode(4);

        TreeNode t = new TreeNode(5);

        t.left = m1;
        t.right = m2;
        m1.left = b1;
        m1.right = b2;
        m2.left = b3;
        m2.right = b4;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> l = new ArrayList<>();


        return null;
    }

}
