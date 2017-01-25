/**
 * Created by DrDan on 1/25/2017.
 */
public class CanCompleteCircuit {

    public void test(){
        int[] gas = new int[] {2,2,3,2,5};
        int[] cost = new int[]{3,4,2,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int distance = gas.length;
        int travelled = 0;
        int i = 0;
        int counter = 0;
        int start = 0;
        int tank = 0;
        while (counter < distance*2 && travelled < distance){
            tank += gas[i];
            System.out.println("tank: " + tank + ", i: " + i);
            if (tank >= cost[i]){
                travelled++;
                tank -= cost[i];
            }
            else {
                tank = 0;
                travelled = 0;
                start = i+1;
            }
            i++; counter++;
            i%=distance;
        }
        return travelled == distance ? start : -1;
    }

}
