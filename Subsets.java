import java.util.ArrayList;
import java.util.List;
/**
 * Created by DrDan on 1/26/2017.
 */
public class Subsets {

    public void test(){

        System.out.println(subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i=0; i<(Math.pow(2, nums.length)); i++){
            List<Integer> tmp = new ArrayList<>();
            for (int x=0; x<nums.length; x++){
                if ((i & (1 << x)) != 0){
                    tmp.add(nums[x]);
                }
            }
            l.add(tmp);
        }
        return l;
    }

}
