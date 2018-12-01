package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 Example:

 Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

 Output: ["AAAAACCCCC", "CCCCCAAAAA"]

 * Created by huaxiufeng on 18/12/1.
 */
public class LC187RepeatedDNASequences {

    public List<String> findRepeatedDnaSequencesSimple(String s) {
        int DNA_LEN = 10;
        if (null == s || s.length() < DNA_LEN) {
            return new ArrayList<>();
        }
        Set<String> sequenceSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        for (int i = DNA_LEN; i <= s.length(); i++) {
            String substr = s.substring(i - DNA_LEN, i);
            if (sequenceSet.contains(substr)) {
                resultSet.add(substr);
            }
            sequenceSet.add(substr);
        }
        return new ArrayList<>(resultSet);
    }

    /**
     * https://en.wikipedia.org/wiki/Rolling_hash
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int DNA_LEN = 10;
        if (null == s || s.length() < DNA_LEN) {
            return new ArrayList<>();
        }
        Set<Integer> sequenceSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        int rhash = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= DNA_LEN) {
                // 把最左边的数清掉
                // 需要(DNA_LEN-1)*2个1
                rhash = ((1 << (2*(DNA_LEN-1))) - 1) & rhash;
            }
            rhash = (rhash << 2) + getCharValue(s.charAt(i));
            if (i >= DNA_LEN - 1) {
                if (!sequenceSet.add(rhash)) {
                    resultSet.add(s.substring(i+1-DNA_LEN, i+1));
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    /**
     * 可以理解为4进制
     * @param c
     * @return
     */
    private int getCharValue(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        LC187RepeatedDNASequences solution = new LC187RepeatedDNASequences();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // ["AAAAACCCCC","CCCCCAAAAA"]
    }
}
