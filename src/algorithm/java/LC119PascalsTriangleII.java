package algorithm.java;

import java.util.LinkedList;
import java.util.List;

public class LC119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new LinkedList<>();
        for (int row = 0; row <= rowIndex; row++) {
            ret.add(0, 1);
            for (int i = 1; i < row; i++) {
                ret.set(i, ret.get(i) + ret.get(i + 1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC119PascalsTriangleII solution = new LC119PascalsTriangleII();
        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(5));
    }
}
