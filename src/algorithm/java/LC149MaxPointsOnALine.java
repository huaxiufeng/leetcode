package algorithm.java;

import java.util.HashMap;
import java.util.Map;

import algorithm.java.data.Point;

/**
 * Created by huaxiufeng on 19/3/5.
 */
public class LC149MaxPointsOnALine {

    /**
     * 点[x1, y1], [x2, y2]
     * 斜率：slope = (y2 - y1) / (x2 - x1);
     * 截距（直线与Y轴的交点坐标）：intercept = y1 - x1*gradient = y2 - x2*gradient;
     */
    public int maxPoints0(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameLine = 1;
            for (int j = i + 1; j < points.length; j++) {
                int dy = points[j].y - points[i].y;
                int dx = points[j].x - points[i].x;
                if (dy == 0 && dx == 0) {
                    samePoint++;
                    continue;
                }
                int gcd = gcd(dy, dx);
                if (gcd != 0) {
                    dy /= gcd;
                    dx /= gcd;
                }
                int slopeKey = (dx << 32) + dy;
                if (map.containsKey(slopeKey)) {
                    map.put(slopeKey, map.get(slopeKey) + 1);
                } else {
                    map.put(slopeKey, 2);
                }
                sameLine = Math.max(sameLine, map.get(slopeKey));
            }
            max = Math.max(max, samePoint + sameLine);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * 点[x1, y1], [x2, y2], [x3, y3]
     * 判断3个点在一条直线上
     * (y2 - y1) / (x2 - x1) = (y3 - y1) / (x3 - x1)   ->   (y2 - y1) * (x3 - x1) - (y3 - y1) * (x2 - x1) == 0
     * x1*y3 + x2*y1 + x3*y2 - x1*y2 - x2*y3 - x3*y1 == 0
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 1;
            for (int j = i + 1; j < points.length; j++) {
                // 如果i和j是同一个点，那么它们和任意一个点都在一条直线上，因此不需要考虑
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                    continue;
                }
                int count = 0;
                for (int k = 0; k < points.length; k++) {
                    if (sameLine(points[i], points[j], points[k])) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            // 如果所有的点都是相同的，那么就不会进入三点共线的比较
            max = Math.max(max, samePoint);
        }
        return max;
    }

    private boolean sameLine(Point p1, Point p2, Point p3) {
        // int类型相乘可能溢出，65536 * 65536 = 0，所以先转成long再判断
        return (long)p1.x * p3.y + (long)p2.x * p1.y + (long)p3.x * p2.y - (long)p1.x * p2.y - (long)p2.x * p3.y - (long)p3.x * p1.y == 0L;
    }

    public static void main(String[] args) {
        LC149MaxPointsOnALine solution = new LC149MaxPointsOnALine();
        System.out.println(solution.maxPoints(new Point[]{new Point(1,1), new Point(3,2), new Point(5,3), new Point(4,1), new Point(2,3), new Point(1,4)})); // 4
        System.out.println(solution.maxPoints(new Point[]{new Point(0,0), new Point(1,65536), new Point(65536,0)})); // 2
        System.out.println(solution.maxPoints(new Point[]{new Point(1,1), new Point(1,1), new Point(1,1)})); // 3
        System.out.println(solution.maxPoints(new Point[]{new Point(1,1), new Point(1,1), new Point(1,1)})); // 3
        System.out.println(solution.maxPoints(new Point[]{new Point(1,1), new Point(3,2), new Point(5,3), new Point(4,1), new Point(2,3), new Point(1,4)})); // 4
        System.out.println(solution.maxPoints(new Point[]{new Point(1,1), new Point(2,2), new Point(3,3)})); // 3
    }
}
