package algorithm.java;

import java.util.Stack;

public class LC71SimplifyPath {

    public String simplifyPath(String path) {
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        Stack<String> stack = new Stack<>();
        int begin = 0;
        for (int end = begin + 1; end < path.length(); end++) {
            if (path.charAt(end) != '/') {
                continue;
            }
            int len = end - begin;
            if (len > 1) {
                String s = path.substring(begin + 1, end);
                if ("..".equals(s)) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else if (!".".equals(s)) {
                    stack.push(s);
                }
            }
            begin = end;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.insert(0, "/" + stack.pop());
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        LC71SimplifyPath solution = new LC71SimplifyPath();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/..")); // /a/b/c
        System.out.println(solution.simplifyPath("/home//foo/")); // /home/foo
        System.out.println(solution.simplifyPath("/home/")); // /home
        System.out.println(solution.simplifyPath("/../")); // /
        System.out.println(solution.simplifyPath("/a/./b/../../c/")); // /c
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//")); // /c
    }
}
