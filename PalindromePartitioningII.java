/**
 * Created by DrDan on 2/9/2017.
 */
public class PalindromePartitioningII {

    public void test(){
        minCut("abacd");
    }

    public int minCut(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            memo[i][i]=0;
        }

        for (int i=1; i<s.length(); i++){
            for (int j=0; j<(s.length()-i); j++){
                System.out.println("(" + j + ", " + (j+i) + ")");
            }
        }

        return 0;
    }
}
