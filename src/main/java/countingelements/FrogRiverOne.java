package countingelements;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        if (A.length == 1) {
            if (X == 1) {
                return 0;
            } else {
                return -1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (!map.containsKey(a)) {
                map.put(a, 1);
                sum += 1;

                if (sum == X) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;
        int X = 5;
        FrogRiverOne main = new FrogRiverOne();
        int result = main.solution(X, A);
        System.out.println(result);

    }
}
