package algorithm.java.data;

/**
 * Created by huaxiufeng on 17/5/21.
 */
public class Interval {
    public int start;
    public int end;

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return start + "->" + end;
    }
}
