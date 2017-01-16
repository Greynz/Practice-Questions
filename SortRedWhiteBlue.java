import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by DrDan on 1/15/2017.
 */
public class SortRedWhiteBlue {
    public void test(){
        int[] colors = new int[]{2,0,0};
        sortColors(colors);
        System.out.println();
        System.out.println();
        for (int n : colors){
            System.out.print(n + ", ");
        }
    }
    public void sortColors(int[] nums) {
        int rIndex = 0;
        int bIndex = nums.length-1;
        for(int i=0; i<=bIndex; i++){
            if (nums[i] == 0){
                while (rIndex < nums.length && nums[rIndex] == 0) rIndex++;
                if (rIndex >= nums.length) break;
                if (rIndex < i){
                    nums[i] = nums[rIndex];
                    nums[rIndex] = 0;
                    rIndex++;
                }
            }
            else if (nums[i] == 2 && bIndex > i){
                while (bIndex >= 0 && nums[bIndex] == 2) bIndex--;
                if (bIndex <= 0) break;
                if (bIndex > i){
                    nums[i] = nums[bIndex];
                    nums[bIndex] = 2;
                    bIndex--;
                    if (nums[i] == 0 && i > rIndex) i--;
                }
            }
        }
    }
}
