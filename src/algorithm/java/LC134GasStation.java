package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/20.
 */
public class LC134GasStation {

    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
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

    /**
     * If car starts at A and can not reach B. Any station between A and B
     can not reach B.(B is the first station that A can not reach.)
     If the total number of gas is bigger than the total number of cost. There must be a solution.
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += (gas[i] - cost[i]);
            sum += (gas[i] - cost[i]);
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        LC134GasStation solution = new LC134GasStation();
        System.out.println(solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3
        System.out.println(solution.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // -1
    }
}
