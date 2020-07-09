package prefixsums;

public class Mushroom {

    public int mushrooms(int[] A, int m, int k) {
        int n = A.length;
        int result = 0;
        int [] pref = prefix_sums(A);

        System.out.println("--LEFT--");
        for (int p = 0; p < Math.min(m, k) + 1; p++) {
            int left_pos = k - p;
            System.out.println("l = " + left_pos);
            int right_pos = Math.min(n - 1, Math.max(k, k + m - 2 * p));
            System.out.println("r = " + right_pos);
            result = Math.max(result, count_total(pref, left_pos, right_pos));
        }

        System.out.println("--RIGHT--");
        for (int p = 0; p < Math.min(m + 1, n - k); p++) {
            int right_pos = k + p;
            System.out.println("r = " + right_pos);
            int left_pos = Math.max(0, Math.min(k, k - (m - 2 * p)));
            System.out.println("l = " + left_pos);
            result = Math.max(result, count_total(pref, left_pos, right_pos));
        }
        return result;
    }

    private int count_total(int []P, int x, int y) {
        return P[y + 1] - P[x];
    }

    private int[] prefix_sums(int []A) {
         int n = A.length;
         int[] P = new int[n + 1];
         for (int k = 1; k < n + 1; k ++) {
             P[k] = P[k - 1] + A[k - 1];
         }
         return P;
    }

    public static void main(String[] args) {
        Mushroom main = new Mushroom();
        int[] A = new int[7];//2 3 7 5 1 3 9
        A[0] = 2;
        A[1] = 3;
        A[2] = 7;
        A[3] = 5;
        A[4] = 1;
        A[5] = 3;
        A[6] = 9;
        //start k = 4 and should perform m = 6 moves
        int k = 4;
        int m = 6;
        int res = main.mushrooms(A, m, k);
        System.out.println(res);
    }
}
