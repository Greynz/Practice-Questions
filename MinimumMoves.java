/**
 * Created by DrDan on 1/21/2017.
 */
public class MinimumMoves {
    public void test(){
        System.out.println(minMoves(new int[]{1,2,3,4}));
    }

    public int minMoves(int[] nums) {
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
        }
        System.out.println(max);
        return total - (total/nums.length);
    }
}
