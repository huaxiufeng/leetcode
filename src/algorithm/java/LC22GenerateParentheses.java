package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/5.
 */
public class LC22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        doGenerate(resultList, new StringBuilder(), n, n);
        return resultList;
    }

    private void doGenerate(List<String> resultList, StringBuilder builder, int left, int right) {
        if (left == 0 && right == 0) {
            resultList.add(builder.toString());
        }
        if (right < left) {
            return;
        }

        if (left > 0) {
            builder.append("(");
            doGenerate(resultList, builder, left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > left) {
            builder.append(")");
            doGenerate(resultList, builder, left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LC22GenerateParentheses solution = new LC22GenerateParentheses();
        System.out.println(solution.generateParenthesis(3));
    }
}
