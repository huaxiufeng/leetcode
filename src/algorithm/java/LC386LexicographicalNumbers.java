package algorithm.java;

import java.util.*;

/**
 Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LC386LexicographicalNumbers {

    /**
     先根遍历树
     The idea is pretty simple.
     If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
     Then we visit every node in pre-order.
        1          2        3    ...
        /\        /\       /\
     10 ...19  20...29  30...39   ....
     */
    public List<Integer> lexicalOrderDfs(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }

    /**
     * 主要的思路是找到下一个数
     * 以45为例，下一个数可能是：
     * 450 - 也就是45*10，如果450<=n
     * 46  - 也就是45+1，如果46<=n
     * 5   - 也就是45/10+1
     * 如果n:600, cur=499，next=5，所以应该不断的除10直到最后一位不是9
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC386LexicographicalNumbers solution = new LC386LexicographicalNumbers();
        System.out.println(solution.lexicalOrder(200));
        System.out.println(solution.lexicalOrder(13));

        List<String> strList = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            strList.add(Integer.toString(i));
        }
        Collections.sort(strList);
        System.out.println(strList);
    }
}
