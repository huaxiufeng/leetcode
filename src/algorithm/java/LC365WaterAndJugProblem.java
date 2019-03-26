package algorithm.java;

/**
 You are given two jugs with capacities x and y litres.
 There is an infinite amount of water supply available.
 You need to determine whether it is possible to measure exactly z litres using these two jugs.

 If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

 Operations allowed:
 . Fill any of the jugs completely with water.
 . Empty any of the jugs.
 . Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

 * Created by huaxiufeng on 19/3/26.
 */
public class LC365WaterAndJugProblem {

    /**
     这道问题其实可以转换为有一个很大的容器，我们有两个杯子，容量分别为x和y，问我们通过用两个杯子往里倒水，和往出舀水，问能不能使容器中的水刚好为z升。
     那么我们可以用一个公式来表达：z = a * x + b * y
     其中a，b为舀水和倒水的次数，正数表示往里舀水，负数表示往外倒水，那么题目中的例子可以写成: 4 = (-2) * 3 + 2 * 5，即3升的水罐往外倒了两次水，5升水罐往里舀了两次水。
     那么问题就变成了对于任意给定的x,y,z，存不存在a和b使得上面的等式成立。
     根据裴蜀定理，对于ax + by = z，有整数解时当且仅当z是a和b的最大公约数d的倍数，那么我们只要只要z % d == 0，上面的等式就有整数解，所以问题就迎刃而解了。
     我们只要看z是不是x和y的最大公约数的倍数就行了，别忘了还有个限制条件x + y >= z，因为x和y不可能称出比它们之和还多的水
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        } if (z == x || z == y) {
            return true;
        }
        int gcd = gcd(x, y);
        return gcd > 0 && z % gcd == 0;
    }

    private int gcd(int x, int y) {
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        LC365WaterAndJugProblem solution = new LC365WaterAndJugProblem();
        System.out.println(solution.canMeasureWater(0, 0, 0)); // true
        System.out.println(solution.canMeasureWater(3, 5, 4)); // true
        System.out.println(solution.canMeasureWater(2, 6, 5)); // false
    }
}
