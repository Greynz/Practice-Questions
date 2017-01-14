import java.util.Arrays;

/**
 * Created by Dan Rogers on 1/13/2017.
 */
public class RotatedBinarySearch {
    public void test(){
        int target = 0;
        int[] test = new int[] {3, 5, 1};
        int index = search(test, target);
        System.out.println("Target Value at index: " + index);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)   return -1;
        if (nums.length == 1)   return nums[0] == target ? 0 : -1;
        if (nums.length == 2)   if (nums[0] == target) return 0; else if (nums[1] == target) return 1; else return -1;

        int pivot = findPivot(nums, 0, nums.length-1);
        if (pivot == -1)        return binarySearch(nums, target);
        if (target < nums[0])   {
            int index = binarySearch(Arrays.copyOfRange(nums, pivot+1, nums.length), target);
            return index == -1 ? -1 : index + pivot + 1;
        }
        return binarySearch(Arrays.copyOfRange(nums, 0, pivot+1), target);
    }

    int findPivot(int nums[], int bot, int top)
    {
        if (top < bot)  return -1;
        if (bot == nums.length-1) return -1;
        if (top == bot) return bot;

        int mid = (bot + top)/2;
        if (mid < top && nums[mid] > nums[mid + 1]) return mid;

        if (nums[mid] < nums[bot])                  //if the bottom value is smaller than the mid value,
            return findPivot(nums, bot, mid-1);       //we know if must contain the pivot, else the other side does
        return findPivot(nums,mid+1, top);

    }

    public int binarySearch(int[] nums, int target){
        int bot = 0;
        int top = nums.length - 1;
        int mid = nums.length/2;
        while (bot <= top && nums[mid] != target) {
            if (target < nums[mid]) {
                top = mid - 1;
                mid = (bot + top) / 2;
            } else {
                bot = mid + 1;
                mid = (bot + top) / 2;
            }
        }
        return (bot <= top) ? mid : -1;
    }
}
