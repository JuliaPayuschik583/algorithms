package arrays;

import java.util.Arrays;

public class CyclicRotation {

    private int[] solution(int[] A, int K) {
        if (A.length == 0 || A.length == K || K%A.length == 0) {
            return A;
        }
        int[] B = A.clone();
        Arrays.sort(B);
        if (B[0] == B[B.length - 1]) {
            return A;
        }

        int[] C = A.clone();
        for (int i = 0; i < A.length; i++) {

            int newIn = i + K + 1 > A.length ? (K + i) - ((K + i) / A.length * A.length) : i + K;

            C[newIn] = A[i];
        }

        return C;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] A = new int[3];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        int K = 8;
        int[] result = cyclicRotation.solution(A, K);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
