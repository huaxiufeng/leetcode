package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/20.
 */
public class LC134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (doCanCompleteCircuit(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }

    private boolean doCanCompleteCircuit(int index, int[] gas, int[] cost) {
        int tank = 0;
        int stationsLeft = gas.length;
        while (stationsLeft > 0) {
            tank += gas[index];
            tank -= cost[index];
            if (tank < 0) {
                return false;
            }
            index++;
            if (index >= gas.length) {
                index = index % gas.length;
            }
            stationsLeft--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC134GasStation solution = new LC134GasStation();
        System.out.println(solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3
        System.out.println(solution.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // -1
    }
}
