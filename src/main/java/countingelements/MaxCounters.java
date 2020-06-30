package countingelements;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        final int condition = N + 1;
        int currentMax = 0;
        int lastUpdate = 0;
        int countersArray[] = new int[N];

        for (int iii = 0; iii < A.length; iii++) {
            int currentValue = A[iii];
            if (currentValue == condition) {
                lastUpdate = currentMax;
            } else {
                int position = currentValue - 1;
                if (countersArray[position] < lastUpdate) {
                    countersArray[position] = lastUpdate + 1;
                } else {
                    countersArray[position]++;
                }

                if (countersArray[position] > currentMax) {
                    currentMax = countersArray[position];
                }
            }

        }

        for (int iii = 0; iii < N; iii++) {
            if (countersArray[iii] < lastUpdate)
                countersArray[iii] = lastUpdate;
        }

        return countersArray;
    }

    public int[] solution2(int N, int[] A) {
        int[] zero = new int[N];

        int max = 0;
        for (int a : A) {
            if (a > N) {
                //set in max counter
                for (int i = 0; i < N; i++) {
                    zero[i] = max;
                }
            } else {
                zero[a - 1] += 1;
                if (max < zero[a - 1]) {
                    max = zero[a - 1];
                }
            }
        }

        return zero;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[7];
        A[0] = 6;
        A[1] = 3;
        A[2] = 1;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;
        MaxCounters main = new MaxCounters();
        int[] result = main.solution(N, A);
        for (int el : result) {
            System.out.print(el + ", ");
        }
    }
}
