package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

 Example:

 n = 15,

 Return:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]
 Subscribe to see which companies asked this question.
 *
 * Created by huaxiufeng on 17/5/21.
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();
        System.out.println(solution.fizzBuzz(99));
    }
}
