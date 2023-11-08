package LeetCode.HappyNumber;

public class Solution {
    int value;

    Solution(int n) {
        this.value = n;
    }

    public boolean isHappy(int n) {
        int eps = 0;
        double sum;

        while (eps < 1000) {
            sum = 0;

            while (n!=0) {
                sum = sum + Math.pow(n%10,2);
                n /= 10;
            }

            if ((int)sum == 1) {
                return true;
            }
            else {
                n = (int)sum;
                eps +=1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution n = new Solution(19);

        System.out.println(n.isHappy(n.value));
    } 
}
