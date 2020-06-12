package arrays;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        Arrays.sort(A);

        for (int i = 1; i < A.length; i+=2) {
            if (A[i-1] != A[i]) {
                return A[i-1];
            }
        }

        return A[A.length - 1];
    }

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 1;  A[1] = 1;  A[2] = 1;
        A[3] = 1;  A[4] = 1;  A[5] = 1;
        A[6] = 4;

        OddOccurrencesInArray main = new OddOccurrencesInArray();
        int result =  main.solution(A);
        System.out.println(result);
    }
}
