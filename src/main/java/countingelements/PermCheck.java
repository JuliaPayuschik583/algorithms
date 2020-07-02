package countingelements;

import java.util.Arrays;

public class PermCheck {

    public int solution(int[] A) {
        if (A.length == 1) {
            if (A[0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        Arrays.sort(A);

        if (A[A.length-1] != A.length) {
            return 0;
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        PermCheck main = new PermCheck();
        int[] A = new int[4];
        A[0] = 4;
        A[1] = 1;
        A[2] = 3;
        A[3] = 2;

        int[] A1 = new int[10];//[9, 5, 7, 3, 2, 7, 3, 1, 10, 8]
        A1[0] = 9;
        A1[1] = 5;
        A1[2] = 7;
        A1[3] = 3;
        A1[4] = 2;
        A1[5] = 7;
        A1[6] = 3;
        A1[7] = 1;
        A1[8] = 10;
        A1[9] = 8;
        int result = main.solution(A1);
        System.out.println(result);
    }
}
