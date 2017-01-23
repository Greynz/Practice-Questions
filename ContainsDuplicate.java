import java.util.HashSet;

/**
 * Created by DrDan on 1/23/2017.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int c : nums){
            if (hs.contains(c))
                return true;
            else
                hs.add(c);
        }
        return false;
    }
}
