package binarygaps;

public class Solution {

    public int solution(int N) {
        final String binaryStr = Integer.toBinaryString(N);

        int max = 0;
        int count = 0;
        boolean isOpen = false;
        for (char ch: binaryStr.toCharArray()) {
            if (ch == '1') {
                if (isOpen) {
                    isOpen = false;
                    if (max < count) {
                        max = count;
                    }
                    count = 0;
                    continue;
                } else {
                    isOpen = true;
                    continue;
                }
            } else {
                //ch=0
                count += 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(529);
        System.out.println(result);
    }
}
