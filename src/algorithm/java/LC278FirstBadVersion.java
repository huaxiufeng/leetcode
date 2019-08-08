package algorithm.java;

public class LC278FirstBadVersion {
    private int firstBadVersion;

    public LC278FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int bad = n;
        int begin = 1, end = n;
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            if (isBadVersion(mid)) {
                bad = mid;
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return bad;
    }

    private boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public static void main(String[] args) {
        System.out.println(new LC278FirstBadVersion(4).firstBadVersion(5)); // 4
        System.out.println(new LC278FirstBadVersion(1702766719).firstBadVersion(2126753390)); // 1702766719
    }
}
