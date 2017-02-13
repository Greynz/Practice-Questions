import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by DrDan on 1/31/2017.
 */
public class ConstructBinaryTree {

    public void test(){
        //TreeNode r2 = buildTree2(new int[]{4,5,1,6,3,7}, new int[]{4,5,6,7,3,1});
        TreeNode r = buildTree(new int[]{4,5,1,6,3,7}, new int[]{4,5,6,7,3,1});
        preOrder(r);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
            hm.put(inorder[i], i);
        return buildTreeConstruct(inorder, postorder, 0, 0, inorder.length, hm);
    }

    public TreeNode buildTreeConstruct(int[] inorder, int[] postorder, int startI, int startP, int length, HashMap<Integer, Integer> hm){
        if (length < 1 || startI<0 || startP<0)
            return null;

        int middle = hm.getOrDefault(postorder[startP+length-1], -1);

        TreeNode root = new TreeNode(postorder[startP+length-1]);

        root.left = buildTreeConstruct(inorder, postorder, startI, startP, middle-startI, hm);
        root.right = buildTreeConstruct(inorder, postorder, middle+1, startP+(middle-startI), length-(middle-startI+1), hm);

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder){
        if (postorder.length < 1)
            return null;


        System.out.print("inorder: ");
        for (int x : inorder){
            System.out.print(x);
        }

        System.out.print(",   postorder: ");
        for (int x : postorder){
            System.out.print(x);
        }
        System.out.println();

        int rIndex = -1;
        for (int i=0; i<inorder.length; i++){
            if (inorder[i] == postorder[postorder.length-1]){
                rIndex = i;
            }
        }

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        TreeNode left = buildTree2 ( Arrays.copyOfRange(inorder, 0,rIndex), Arrays.copyOfRange(postorder, 0,rIndex) );
        TreeNode right = buildTree2( Arrays.copyOfRange(inorder, rIndex+1,inorder.length), Arrays.copyOfRange(postorder, rIndex,postorder.length-1) );

        root.left = left;
        root.right = right;

        return root;
    }


    public void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + ",  ");
        preOrder(root.left);
        preOrder(root.right);
    }

}
