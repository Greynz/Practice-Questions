import java.util.HashMap;
import java.util.Map;

/**
 * Created by DrDan on 1/23/2017.
 */
public class NumberOfBoomerangs {
    public void test(){
        int[][] x = new int[][]{  {1,1}, {2,2}, {3,3}  };
        System.out.println(numberOfBoomerangs(x));
    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int pairs = 0;
        for (int i=0; i<points.length; i++){
            for (int j=0; j<points.length; j++){
                if (i==j)
                    continue;
                int x = (int)(Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2));
                hm.put(x, hm.getOrDefault(x, 0) + 1);
            }
            for (int d : hm.values()){
                pairs += d*(d-1);
            }
            hm.clear();
        }
        return pairs;
    }
}
