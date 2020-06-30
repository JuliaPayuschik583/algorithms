package countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {

    public int solution(int[] A) {
        Arrays.sort(A);

        if (A.length == 1) {
            if (A[0] < 0) {
                return 1;
            }
            int result = A[0] - 1;
            result = result <= 0 ? A[0] + 1 : result;
            return result;
        }


        boolean isStart = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] <= 0 || A[i - 1] == A[i]) {
                continue;
            }
            int diff = A[i] - A[i - 1];
            if (diff > 1) { //4 6
                if (isStart) {
                    return 1;
                }
                return A[i - 1] + 1;
            }
            if (A[i - 1] == 1) {
                isStart = false;
            }
        }

        if (isStart) {
            return 1;
        }

        int result = A[A.length-1] - 1;
        if (result == A[A.length-2]) {
            result = A[A.length-1] + 1;
        }
        result = result <= 0 ? 1 : result;

        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 1;//1, 3, 6, 4, 1, 2 = 5 // [4, 5, 6, 2] 2,4,5,6  = 1
        A[1] = 3;
        A[2] = 6;
        A[3] = 4;
        A[4] = 1;
        A[5] = 2;

        int[] A1 = new int[6];
        A1[0] = -1;//1, 3, 6, 4, 1, 2 = 5 // [4, 5, 6, 2] 2,4,5,6  = 1
        A1[1] = 0;//1, 3, 6, 4, 1, 2 = 5 // [4, 5, 6, 2] 2,4,5,6  = 1
        A1[2] = 4;//1, 3, 6, 4, 1, 2 = 5 // [4, 5, 6, 2] 2,4,5,6  = 1
        A1[3] = 5;
        A1[4] = 6;
        A1[5] = 2;
//        A1[4] = 1;
//        A1[5] = 2;
//        A[6] = -1;

        //[90, 91, 92, 93] = 1
        int[] A2 = new int[4];
        A2[0] = 90;
        A2[1] = 91;
        A2[2] = 92;
        A2[3] = 93;

        int[] A3 = new int[8];
        A3[0] = 1;
        A3[1] = 2;
        A3[2] = 3;
        A3[3] = 4;
        A3[4] = 5;
        A3[5] = 999998;
        A3[6] = 999997;
        A3[7] = 999996;//=6

        int[] A4 = new int[9];
        A4[0] = 1;
        A4[1] = 2;
        A4[2] = 3;
        A4[3] = 4;
        A4[4] = 5;
        A4[5] = 6;
        A4[6] = 7;
        A4[7] = 8;//=9
        A4[8] = 8;//=9
        MissingInteger main = new MissingInteger();
        int result = main.solution(A4);
        System.out.println(result);
    }
}
