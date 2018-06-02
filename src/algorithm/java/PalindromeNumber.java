package algorithm.java;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by huaxiufeng on 17/9/3.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (0 == x) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reverseX = 0;
        while (x > reverseX) {
            int tail = x % 10;
            x = x / 10;
            reverseX = reverseX * 10 + tail;
        }
        return reverseX == x || reverseX / 10 == x;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1221));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(12345));
        System.out.println(solution.isPalindrome(11));
    }
}
