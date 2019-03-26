package algorithm.java.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 总数n，每页的数量是k的话
 * 时间复杂度是O(n)
 * 空间复杂度是O(n)
 *
 * Created by huaxiufeng on 19/3/24.
 */
public class HostCrowdingAirbnbN {

    static List<String> paginate(int resultsPerPage, List<String> results) {
        int pageCount = (results.size() - 1) / resultsPerPage + 1;
        LinkedList<String>[] pages = new LinkedList[pageCount];
        Set<Integer>[] hostIdSets = new Set[pageCount];
        LinkedList<String> pendingResults = new LinkedList<>();
        for (int i = 0; i < pageCount; i++) {
            pages[i] = new LinkedList<>();
            hostIdSets[i] = new HashSet<>();
        }

        int cursorPageIndex = 0;
        Map<Integer, Integer> hostCountMap = new HashMap<>();
        for (String result : results) {
            int hostId = getHostId(result);
            int hostCount = hostCountMap.getOrDefault(hostId, 0);
            hostCountMap.put(hostId, 1 + hostCount);
            int pageIndex = cursorPageIndex + hostCount;
            if (pageIndex < pageCount) {
                hostIdSets[pageIndex].add(hostId);
                pages[pageIndex].add(result);
                if (hostIdSets[pageIndex].size() >= resultsPerPage) {
                    ++cursorPageIndex;
                }
            } else {
                pendingResults.add(result);
            }
        }

        for (int i = cursorPageIndex; i < pageCount; i++) {
            while (pages[i].size() < resultsPerPage && pendingResults.size() > 0) {
                pages[i].add(pendingResults.removeFirst());
            }
        }

        List<String> pagedResults = new LinkedList<>();
        for (int i = 0; i < pageCount; i++) {
            pagedResults.addAll(pages[i]);
            pages[i].clear();
            if (i < pageCount - 1) {
                pagedResults.add("");
            }
        }

        return pagedResults;
    }

    static private int getHostId(String result) {
        return Integer.valueOf(result.substring(0, result.indexOf(",")));
    }

    public static void main(String[] args) {
        foo(5, Arrays.asList(
                "1,28,300.6,San Francisco",
                "4,5,209.1,San Francisco",
                "20,7,203.4,Oakland",
                "6,8,202.9,San Francisco",
                "6,10,199.8,San Francisco",
                "1,16,190.5,San Francisco",
                "6,29,185.3,San Francisco",
                "7,20,180.0,Oakland",
                "6,21,162.2,San Francisco",
                "2,18,161.7,San Jose",
                "2,30,149.8,San Jose",
                "3,76,146.7,San Francisco",
                "2,14,141.8,San Jose"
        ));
        /*
         1,28,300.6,San Francisco
         4,5,209.1,San Francisco
         20,7,203.4,Oakland
         6,8,202.9,San Francisco
         7,20,180.0,Oakland

         6,10,199.8,San Francisco
         1,16,190.5,San Francisco
         2,18,161.7,San Jose
         3,76,146.7,San Francisco
         6,29,185.3,San Francisco

         6,21,162.2,San Francisco
         2,30,149.8,San Jose
         2,14,141.8,San Jose
         */
    }

    static void foo(int resultsPerPage, List<String> results) {
        List<String> pagedResults = paginate(resultsPerPage, results);
        for (String s : pagedResults) {
            System.out.println(s);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
    }
}
