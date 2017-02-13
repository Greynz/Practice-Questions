/**
 * Created by DrDan on 2/10/2017.
 */
public class PerfectRectangle {

    public void test(){
        int[][] x = new int[][]{
                {1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
        };
        System.out.println(isRectangleCover(x));
    }

    public boolean isRectangleCover(int[][] rectangles) {

        int[] botl = new int[]{-1, -1};
        int[] topr = new int[]{-1, -1};

        int[] boundtr = new int[]{-1, -1};
        int[] boundbl = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int[] c : rectangles) {

            if (c[0] + c[1] < botl[0] + botl[1] || (botl[0] == -1)) {
                botl[0] = c[0];
                botl[1] = c[1];
            }
            if (c[2] + c[3] > topr[0] + topr[1] || topr[0] == -1) {
                topr[0] = c[2];
                topr[1] = c[3];
            }
            if (c[2] > boundtr[0]) boundtr[0] = c[2];
            if (c[3] > boundtr[1]) boundtr[1] = c[3];

            if (c[0] < boundbl[0]) boundbl[0] = c[0];
            if (c[1] < boundbl[1]) boundbl[1] = c[1];
        }

        int xoffset = 0;
        int yoffset = 0;

        int xrange = boundtr[0];
        int yrange = boundtr[1];

        if (boundbl[0] < 0){
            xoffset = boundbl[0] * -1;
            xrange -= boundbl[0];
            botl[0] += xoffset;
            topr[0] += xoffset;
        }
        if (boundbl[1] < 0) {
            yoffset = boundbl[1] * -1;
            yrange -= boundbl[1];
            botl[1] += yoffset;
            topr[1] += yoffset;
        }

        boolean[][] table = new boolean[xrange][yrange];
        int areaCounter = 0;

        for (int[] c : rectangles){
            for (int i=c[0]+xoffset; i<c[2]+xoffset; i++){
                for (int j=c[1]+yoffset; j<c[3]+yoffset; j++){
                    if (i < botl[0] || j < botl[1] || i > topr[0] || j > topr[1])
                        return false;
                    if (table[i][j])
                        return false;
                    else{
                        table[i][j] = true;
                        areaCounter++;
                    }
                }
            }
        }

//        for (boolean[] b : table){
//            for (boolean t : b){
//                System.out.print(t ? " O " : " x ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("Bottom Left: " + botl[0] + ", " + botl[1] + "   " + "Top Right: " + topr[0] + ", " + topr[1]);

        return (areaCounter == (topr[0]-botl[0]) * (topr[1]-botl[1]));
    }


}
