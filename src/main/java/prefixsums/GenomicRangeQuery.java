package prefixsums;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        //used jagged array to hold the prefix sums of each A, C and G genoms
        //we don't need to get prefix sums of T, you will see why.
        int[][] genoms = new int[3][S.length()+1];
        //if the char is found in the index i, then we set it to be 1 else they are 0
        //3 short values are needed for this reason
        short A, C, G;
        for (int i = 0; i < S.length(); i++) {
            A = 0; C = 0; G = 0;
            if ('A' == (S.charAt(i))) {
                A = 1;
            } else if ('C' == (S.charAt(i))) {
                C = 1;
            } else if ('G' == (S.charAt(i))) {
                G = 1;
            }
            //here we calculate prefix sums.
            genoms[0][i + 1] = genoms[0][i] + A;//sum A
            genoms[1][i + 1] = genoms[1][i] + C;//sum C
            genoms[2][i + 1] = genoms[2][i] + G;//sum G
        }

        int[] result = new int[P.length];
        //here we go through the provided P[] and Q[] arrays as intervals
        for (int i = 0; i < P.length; i++) {
            int fromIndex = P[i];
            //we need to add 1 to Q[i],
            //because our genoms[0][0], genoms[1][0] and genoms[2][0]
            //have 0 values by default, look above genoms[0][i+1] = genoms[0][i] + A;
            int toIndex = Q[i] + 1;
            if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) {
                result[i] = 1;//A = 1
            } else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) {
                result[i] = 2;//C = 2
            } else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) {
                result[i] = 3;//G = 3
            } else {
                result[i] = 4;//T = 4
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = new int[3]; int[] Q = new int[3];
        P[0] = 2;    Q[0] = 4;
        P[1] = 5;    Q[1] = 5;
        P[2] = 0;    Q[2] = 6;

        int[] P2 = new int[1]; int[] Q2 = new int[1];
        P[0] = 0;    Q[0] = 0;
        GenomicRangeQuery main = new GenomicRangeQuery();
        int[] result = main.solution("A", P2, Q2);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
