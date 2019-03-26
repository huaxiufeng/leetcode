package algorithm.java;

/**
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example :

 Input: n = 10, pick = 6
 Output: 6

 * Created by huaxiufeng on 19/3/26.
 */
public class LC374GuessNumberHigherOrLower {

    public static class GuessGame {
        private int pick;

        public GuessGame(int pick) {
            this.pick = pick;
        }

        public int guess(int num) {
            if (num > this.pick) {
                return -1;
            } else if (num < this.pick) {
                return 1;
            }
            return 0;
        }
    }

    public static class Solution extends GuessGame {

        public Solution(int pick) {
            super(pick);
        }

        public int guessNumber(int n) {
            int begin = 0, end = n;
            while (begin <= end) {
                int num = (end - begin) / 2 + begin;
                int res = guess(num);
                if (res < 0) {
                    end = num - 1;
                } else if (res > 0) {
                    begin = num + 1;
                } else {
                    return num;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1702766719);
        System.out.println(solution.guessNumber(2126753390));
    }
}
