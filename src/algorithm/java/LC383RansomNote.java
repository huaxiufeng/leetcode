package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/12.
 */
public class LC383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (null == ransomNote) {
            return true;
        } else if (null == magazine) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int rn = arr[magazine.charAt(i) - 'a'];
            if (rn > 0) {
                arr[magazine.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC383RansomNote solution = new LC383RansomNote();
        System.out.println(solution.canConstruct("aa", "aab")); // true
        System.out.println(solution.canConstruct("aa", "ab")); // false
    }
}
