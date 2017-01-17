/**
 * Created by DrDan on 1/16/2017.
 */
public class SearchInsertPosition {

    public void test(){
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    public int searchInsert(int[] nums, int target){
        int l=0; int r=nums.length-1; int mid=0;
        if (r == -1)
            return 0;
        while (l < r){
            mid = (l+r)/2;
            if (target == nums[mid])
                return mid;
            if (target < nums[mid])
                r = mid-1;
            else l = mid+1;
        }
        if (l == r && nums[l] == target)
            return l;
        if (nums[l] < target)
            return l+1;
        else return l;
    }
}
