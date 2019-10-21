package algorithm.java;

public class LC190ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r = (r << 1) + (n & 1);
            n = n >> 1;
        }
        return r;
    }

    public static void main(String[] args) {
        LC190ReverseBits solution = new LC190ReverseBits();
        System.out.println(solution.reverseBits(43261596)); // 964176192
    }
}
