package algorithm.java.hackerrank;

/**
 * Created by huaxiufeng on 19/3/24.
 */
public class TheGridSearch {

    static String gridSearch(String[] G, String[] P) {
        int gHeight = G.length;
        int gWidth = G[0].length();
        int pHeight = P.length;
        int pWidth = P[0].length();
        for (int i = 0; i < gHeight - pHeight + 1; i++) {
            for (int j = 0; j < gWidth - pWidth + 1; j++) {
                if (G[i].charAt(j) == P[0].charAt(0)) {
                    boolean found = true;
                    for (int m = 0; found && m < pHeight; m++) {
                        for (int n = 0; n < pWidth; n++) {
                            if (G[i+m].charAt(j+n) != P[m].charAt(n)) {
                                found = false;
                                break;
                            }
                        }
                    }
                    if (found) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(gridSearch(new String[]{
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                //"7053106601",
                //"0834282956",
                //"4607924137"
        }, new String[]{
                "9505",
                "3845",
                "3530"
        })); // YES
        System.out.println(gridSearch(new String[]{
                "400453592126560",
                "114213133098692",
                "474386082879648",
                "522356951189169",
                "887109450487496",
                "252802633388782",
                "502771484966748",
                "075975207693780",
                "511799789562806",
                "404007454272504",
                "549043809916080",
                "962410809534811",
                "445893523733475",
                "768705303214174",
                "650629270887160"
        }, new String[]{
                "99",
                "99"
        })); // NO
    }
}
