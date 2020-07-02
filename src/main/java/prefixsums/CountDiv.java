package prefixsums;

public class CountDiv {

    public int solution(int A, int B, int K) {
        if (K == 1) {
            if (A == 1) {
                return B;
            }
            int result = B - A;
            if (A == 0) {
                result += 1;
            }
            return result == 0 ? 1 : result;
        }

        if (A == B) {
            return B%K == 0 ? 1 : 0;
        }

        int result = (int) (Math.ceil((double)B / K) - Math.ceil((double)A / K));

        if (B%K == 0) {
            result += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        CountDiv main = new CountDiv();
        int result = main.solution(0, 14, 2);//0, 13, 2
        System.out.println(result);
    }
}
