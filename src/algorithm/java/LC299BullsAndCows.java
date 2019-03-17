package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number
 * exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

 Please note that both secret number and friend's guess may contain duplicate digits.

 * Created by huaxiufeng on 19/3/17.
 */
public class LC299BullsAndCows {

    public String getHint(String secret, String guess) {
        int len = secret.length();
        int a = 0, b = 0;
        int[] sCountArr = new int[26];
        int[] gCountArr = new int[26];
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                a++;
            } else {
                sCountArr[sc - '0']++;
                gCountArr[gc - '0']++;
            }
        }
        for (int i = 0; i < 26; i ++) {
            if (sCountArr[i] > 0 && gCountArr[i] > 0) {
                b += Math.min(sCountArr[i], gCountArr[i]);
            }
        }
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        LC299BullsAndCows solution = new LC299BullsAndCows();
        System.out.println(solution.getHint("1807", "7810")); // 1A3B
        System.out.println(solution.getHint("1123", "0111")); // 1A1B
    }
}
