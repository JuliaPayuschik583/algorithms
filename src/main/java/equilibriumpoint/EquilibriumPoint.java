package equilibriumpoint;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumPoint {
    /* An equilibrium-point of array is an element for which sum on the left is equal to the sum on the right.
     Write a method that receives an array of integers as an argument and finds all equilibrium-points.
     The method needs to return indexes sorted in a descending order.
    Method signature:
    */
/*
Example 1
Input:
[1, 2, 3, 4, -1]
Output:
[2]

Example 2
Input:
[1, 2, 3, 4, 5]
Output:
[]

Example 3
Input:
[1, 1, -1, -1, 3] 0
Output:
[4, 2, 1]

Example 4
Input:
0[1, 1, -1]
Output:
[0]
*/

    List<Integer> equalSum(int[] data) {
        List<Integer> indexs = new ArrayList<>();
        //0[1, 1, -1]
        for (int i= -1; i < data.length; i++) {

            int leftSum = 0;
            if (i > -1) {
                for (int j = 0; j < i + 1; j++) {
                    leftSum += data[j];
                }
            }

            int rightSum = 0;
            for (int j = i + 2; j < data.length; j++) {
                rightSum += data[j];
            }

            if (i == 0 && rightSum == 0) {
                indexs.add(i);
            } else if (i == data.length - 1 && leftSum == 0) {
                indexs.add(i);
            }

            if (leftSum == rightSum) {
                indexs.add(i + 1);
            }
        }

        return indexs;
    }

    public static void main(String[] args) {
        int[] t = new int[5];//[1, 2, 3, 4, -1] //[2]
        t[0] = 1;
        t[1] = 2;
        t[2] = 3;
        t[3] = 4;
        t[4] = -1;

        int[] t2 = new int[3];//[1, 1, -1] //[0]
        t2[0] = 1;
        t2[1] = 1;
        t2[2] = -1;

        int[] t3 = new int[5];//[1, 1, -1, -1, 3] 0 //expected [4, 2, 1]
        t3[0] = 1;
        t3[1] = 1;
        t3[2] = -1;
        t3[3] = -1;
        t3[4] = 3;
        final EquilibriumPoint main = new EquilibriumPoint();
        List<Integer> result = main.equalSum(t3);
        System.out.println(result);
    }
}
