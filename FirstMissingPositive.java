import java.util.HashSet;

/**
 * Created by DrDan on 2/9/2017.
 */
public class FirstMissingPositive {

    public void test(){
        System.out.println(firstMissingPositive(new int[]{1,2,3,5}));
    }


    public int firstMissingPositive(int[] nums) {
        int max = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        for (int i=0; i<nums.length; i++){
            if (!hs.contains(i+1)){
                return i+1;
            }
            else {
                max = Math.max(max, i+1);
            }
        }
        return max+1;
    }
}
