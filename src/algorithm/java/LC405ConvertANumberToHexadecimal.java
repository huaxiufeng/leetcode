package algorithm.java;

public class LC405ConvertANumberToHexadecimal {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            int n = num & 0xf;
            num = num >>> 4;
            char c = n <= 9 ? (char)('0' + n) : (char)('a' + n - 10);
            builder.insert(0, c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LC405ConvertANumberToHexadecimal solution = new LC405ConvertANumberToHexadecimal();
        System.out.println(solution.toHex(0)); // 0
        System.out.println(solution.toHex(26)); // 1a
        System.out.println(solution.toHex(-1)); // ffffffff
        System.out.println(solution.toHex(-2)); // fffffffe
    }
}
