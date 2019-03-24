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
 * Created by huaxiufeng on 19/3/24.
 */
public class HostCrowdingAirbnb {

    static List<String> paginate(int resultsPerPage, List<String> results) {
        Map<String, Integer> hostIdMap = new HashMap<>();
        for (String result : results) {
            hostIdMap.put(result, getHostId(result));
        }
        List<String> pagedResults = new LinkedList<>();
        LinkedList<String> linkedResults = new LinkedList<>(results);
        do {
            LinkedList<String> onePageResults = extractOnePage(resultsPerPage, linkedResults, hostIdMap);
            pagedResults.addAll(onePageResults);
            if (linkedResults.size() > 0) {
                pagedResults.add("");
            }
        } while (linkedResults.size() > 0);
        return pagedResults;
    }

    private static LinkedList<String> extractOnePage(int resultsPerPage, LinkedList<String> results, Map<String, Integer> hostIdMap) {
        Set<Integer> hostIdSet = new HashSet<>();
        LinkedList<String> pageResults = new LinkedList<>();

        Iterator<String> iter = results.iterator();
        while (iter.hasNext()) {
            String result = iter.next();
            int hostId = hostIdMap.get(result);
            if (!hostIdSet.contains(hostId)) {
                hostIdSet.add(hostId);
                iter.remove();
                pageResults.add(result);
                if (pageResults.size() >= resultsPerPage) {
                    break;
                }
            }
        }

        iter = results.iterator();
        while (pageResults.size() < resultsPerPage && iter.hasNext()) {
            pageResults.add(iter.next());
            iter.remove();
        }
        return pageResults;
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
    }

    static void foo(int resultsPerPage, List<String> results) {
        List<String> pagedResults = paginate(resultsPerPage, results);
        for (String s : pagedResults) {
            System.out.println(s);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
    }
}
