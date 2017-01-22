/**
 * Created by DrDan on 1/21/2017.
 */
public class MinimumMoves {
    public void test(){
        System.out.println(minMoves(new int[]{1,2,3,4}));
    }

    public int minMoves(int[] nums) {
        int min = nums[0];
        int count = 0;
        for (int i=1; i<nums.length; i++){
            if (nums[i] < min)
                min = nums[i];
        }

        for (int i=0; i<nums.length; i++){
            count += nums[i] - min;
        }

        return count;
    }
}
