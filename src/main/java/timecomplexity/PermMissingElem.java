package timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        Arrays.sort(A);

        boolean isExistFirst = A[0] == 1;

        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if (diff != 1) {
                return A[i] - 1;
            }
        }

        if (!isExistFirst) {
            return A[0] - 1;
        } else {
            return A[A.length-1] + 1;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[1];
        A[0] = 5;
        PermMissingElem main = new PermMissingElem();
        int result = main.solution(A);
        System.out.println(result);
    }
}
