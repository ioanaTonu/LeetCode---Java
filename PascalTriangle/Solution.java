// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Example 2:
// Input: numRows = 1
// Output: [[1]]

package LeetCode.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int numRows;
    List<List<Integer>> pascalTriangle;

    Solution(int nr) {
        numRows = nr;
        pascalTriangle = new ArrayList<>();
    }

    void PascalTriangleFunction() {
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else {
                List<Integer> prevRow = pascalTriangle.get(i - 1);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
                row.add(1);
            }
            pascalTriangle.add(row);
        }
    }

    void printPascalTriangle() {
        System.out.print("[");
        for (int i = 0; i < numRows; i++) {
            System.out.print("[");
            List<Integer> row = pascalTriangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j < row.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < numRows - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution p = new Solution(5);

        p.PascalTriangleFunction();
        p.printPascalTriangle();
    }
}
