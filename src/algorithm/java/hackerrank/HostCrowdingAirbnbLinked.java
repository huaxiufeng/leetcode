package algorithm.java.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 总数n，每页的数量是k的话
 * 最坏的情况下，n + (n-k) + (n-2k) + ... + 2k + k，总数(n/k)次，和为n(n+k)/(2k)
 * 最好的情况下，k + k + k + ... + k，总数(n/k)次，和为n
 * 总体的复杂度是O(n^2/k)
 * 空间复杂度是 O(n)
 *
 * Created by huaxiufeng on 19/3/24.
 */
public class HostCrowdingAirbnbLinked {

    static List<String> paginate(int resultsPerPage, List<String> results) {
        Map<String, Integer> hostIdMap = new HashMap<>();
        for (String result : results) {
            hostIdMap.put(result, getHostId(result));
        }
        LinkedList<String> pagedResults = new LinkedList<>();
        LinkedList<String> originalResults = new LinkedList<>(results);
        do {
            extractOnePage(resultsPerPage, originalResults, hostIdMap, pagedResults);
            if (originalResults.size() > 0) {
                pagedResults.add("");
            }
        } while (originalResults.size() > 0);
        return pagedResults;
    }

    private static void extractOnePage(int resultsPerPage, LinkedList<String> originalResults,
            Map<String, Integer> hostIdMap, LinkedList<String> pagedResults) {
        Set<Integer> hostIdSet = new HashSet<>();
        int pageItemCount = 0;
        Iterator<String> iter = originalResults.iterator();
        while (iter.hasNext()) {
            String result = iter.next();
            int hostId = hostIdMap.get(result);
            if (!hostIdSet.contains(hostId)) {
                hostIdSet.add(hostId);
                pagedResults.add(result);
                iter.remove();
                pageItemCount++;
                if (pageItemCount >= resultsPerPage) {
                    break;
                }
            }
        }
        iter = originalResults.iterator();
        while (pageItemCount < resultsPerPage && iter.hasNext()) {
            pagedResults.add(iter.next());
            iter.remove();
            pageItemCount++;
        }
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
