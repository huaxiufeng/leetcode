package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class LC401BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        int[] hourBits = new int[12];
        int[] minuteBits = new int[60];
        for (int i = 0; i < 12; i++) {
            hourBits[i] = countBits(i);
        }
        for (int i = 0; i < 60; i++) {
            minuteBits[i] = countBits(i);
        }
        for (int hour = 0; hour <= num; hour++) {
            int minute = num - hour;
            if (hour > 4 || minute > 6) {
                continue;
            }
            for (int i = 0; i < hourBits.length; i++) {
                for (int j = 0; j < minuteBits.length; j++) {
                    if (hourBits[i] == hour && minuteBits[j] == minute) {
                        result.add( i + ":" + (j >= 10 ? j : "0" + j));
                    }
                }
            }
        }
        return result;
    }

    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LC401BinaryWatch solution = new LC401BinaryWatch();
        System.out.println(solution.readBinaryWatch(2));
        System.out.println(solution.readBinaryWatch(1));
        System.out.println(solution.readBinaryWatch(5));
    }
}
