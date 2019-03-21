package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Created by huaxiufeng on 19/3/22.
 */
public class LC332ReconstructItinerary {

    /**
     * 欧拉路径，DFS
     * @param tickets
     * @return
     */
    public List<String> findItinerary0(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> queue = map.get(ticket[0]);
            if (null == queue) {
                queue = new PriorityQueue<>();
                map.put(ticket[0], queue);
            }
            queue.add(ticket[1]);
        }
        List<String> result = new ArrayList<>();
        dfs(map, result, "JFK");
        return result;
    }

    public void dfs(Map<String, PriorityQueue<String>> map, List<String> result, String from) {
        PriorityQueue<String> arrivals = map.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(map, result, arrivals.poll());
        }
        result.add(0, from);
    }

    /**
     * 利用栈，深度优先
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> queue = map.get(ticket[0]);
            if (null == queue) {
                queue = new PriorityQueue<>();
                map.put(ticket[0], queue);
            }
            queue.add(ticket[1]);
        }

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        while (!stack.isEmpty()) {
            String s = stack.peek();
            PriorityQueue<String> queue = map.get(s);
            if (queue != null && queue.size() > 0) {
                stack.push(queue.poll());
            } else {
                result.add(0, s);
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC332ReconstructItinerary solution = new LC332ReconstructItinerary();
        System.out.println(solution.findItinerary(new String[][] {
                {"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
        })); // ["JFK","NRT","JFK","KUL"]
        System.out.println(solution.findItinerary(new String[][] {
                {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
        })); // ["JFK", "MUC", "LHR", "SFO", "SJC"]
        System.out.println(solution.findItinerary(new String[][] {
                {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
        })); // ["JFK","ATL","JFK","SFO","ATL","SFO"]
    }
}
