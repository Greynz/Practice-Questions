import java.util.HashSet;

/**
 * Created by DrDan on 1/27/2017.
 */
public class LargestRectangleInHistogram {

    public void test(){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public int largestRectangleArea(int[] heights) {

        HashSet<Integer> map = new HashSet<>();

        int total = 0;
        for (int i=0; i<heights.length; i++){
            int curr = heights[i];
            if (map.contains(curr))
                continue;
            map.add(curr);
            int tmpTotal = curr;
            int l=i-1;
            int r=i+1;
            boolean validLeft = true; boolean validRight = true;
            while (validLeft || validRight){

                if (l >= 0 && heights[l] >= curr){
                    tmpTotal += curr;
                    l--;
                }
                else
                    validLeft = false;

                if (r < heights.length && heights[r] >= curr){
                    tmpTotal += curr;
                    r++;
                }
                else
                    validRight = false;
            }
            total = Math.max(total, tmpTotal);
        }

        return total;
    }

}
