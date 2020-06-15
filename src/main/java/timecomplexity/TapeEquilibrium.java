package timecomplexity;

public class TapeEquilibrium {
    //|(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|


    public int solution(int[] A) {
        if (A.length == 2) {
            return Math.abs(A[0] - A[1]);
        }

        int[] specNum = new int[A.length];
        specNum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            specNum[i] = specNum[i - 1] + A[i];
        }

        int minSum = 1000;

        for (int i = 0; i < specNum.length -1; i++) {
            int curr = Math.abs(specNum[i] - (specNum[specNum.length - 1] - specNum[i]));
            if (curr == 0) {
                return 0;
            }
            minSum = minSum >= curr ? curr : minSum;
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = -10;
        A[1] = -20;
        A[2] = -30;
        A[3] = -40;
        A[4] = 100;
        TapeEquilibrium main = new TapeEquilibrium();
        int result = main.solution(A);
        System.out.println(result);
    }
}
