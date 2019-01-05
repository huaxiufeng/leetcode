package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/6.
 */
public class LC223RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - overlapLen(A, C, E, G) * overlapLen(B, D, F, H);
    }

    private int overlapLen(int a, int b, int c, int d) {
        if (c >= b || d <= a) {
            return 0;
        }
        return Math.min(d, b) - Math.max(c, a);
    }

    public static void main(String[] args) {
        LC223RectangleArea solution = new LC223RectangleArea();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2)); // 45
    }
}
