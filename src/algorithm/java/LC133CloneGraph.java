package algorithm.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import algorithm.java.data.UndirectedGraphNode;

/**
 * Created by huaxiufeng on 18/12/16.
 */
public class LC133CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        map.put(node, clonedNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode gn = queue.poll();
            UndirectedGraphNode cgn = map.get(gn);
            for (UndirectedGraphNode n : gn.neighbors) {
                if (!map.containsKey(n)) {
                    UndirectedGraphNode cn = new UndirectedGraphNode(n.label);
                    map.put(n, cn);
                    queue.add(n);
                }
                cgn.neighbors.add(map.get(n));
            }
        }
        return clonedNode;
    }

    public static void main(String[] args) {
        LC133CloneGraph solution = new LC133CloneGraph();
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
        UndirectedGraphNode root = solution.cloneGraph(node0);
        int x = 0;
    }
}
