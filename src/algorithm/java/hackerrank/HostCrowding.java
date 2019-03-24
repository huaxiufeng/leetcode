package algorithm.java.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by huaxiufeng on 19/3/24.
 */
public class HostCrowding {

    static List<String> paginate(int resultsPerPage, List<String> results) {
        Map<String, Integer> hostIdMap = new HashMap<>();
        for (String result : results) {
            hostIdMap.put(result, getHostId(result));
        }
        List<String> pagedResults = new ArrayList<>();
        do {
            List<List<String>> pageAndLeft = extractOnePage(resultsPerPage, results, hostIdMap);
            pagedResults.addAll(pageAndLeft.get(0));
            results = pageAndLeft.get(1);
            if (results.size() > 0) {
                pagedResults.add("");
            }
        } while (results.size() > 0);
        return pagedResults;
    }

    private static List<List<String>> extractOnePage(int resultsPerPage, List<String> results, Map<String, Integer> hostIdMap) {
        Set<Integer> hostIdSet = new HashSet<>();
        List<String> pageResults = new ArrayList<>();
        List<String> leftResults = new ArrayList<>();
        int index = 0;
        while (index < results.size()) {
            String result = results.get(index++);
            int hostId = hostIdMap.get(result);
            if (!hostIdSet.contains(hostId)) {
                pageResults.add(result);
                hostIdSet.add(hostId);
                if (pageResults.size() >= resultsPerPage) {
                    break;
                }
            } else {
                leftResults.add(result);
            }
        }
        while (pageResults.size() < resultsPerPage && index < results.size()) {
            pageResults.add(results.get(index++));
        }
        if (pageResults.size() < resultsPerPage) {
            if (pageResults.size() + leftResults.size() <= resultsPerPage) {
                pageResults.addAll(leftResults);
                leftResults = Collections.emptyList();
            } else {
                int pageResultsSize = pageResults.size();
                pageResults.addAll(leftResults.subList(0, resultsPerPage - pageResults.size()));
                leftResults = leftResults.subList(resultsPerPage - pageResultsSize, leftResults.size());
            }
        } else {
            while (index < results.size()) {
                leftResults.add(results.get(index++));
            }
        }

        return Arrays.asList(pageResults, leftResults);
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
