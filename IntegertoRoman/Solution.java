/*Given an integer, convert it to a roman numeral.

Example 1:
Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.

Example 2:
Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 3:
Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:
1 <= num <= 3999
 */

package IntegertoRoman;

import java.util.HashMap;
import java.util.Scanner;

class Solution {

    static HashMap<Integer, String> symbolsToNumerals(){
        HashMap<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "I");
        numbers.put(5, "V");
        numbers.put(10, "X");
        numbers.put(50, "L");
        numbers.put(100, "C");
        numbers.put(500, "D");
        numbers.put(1000, "M");

        return numbers;
    }

    public static String getOneValue(int n, int poz, HashMap<Integer, String> numbers){
         if (numbers.containsKey(n)){ 
            return numbers.get(n);
        }
        else if (n == 9*Math.pow(10, poz)){
            return numbers.get((int) Math.pow(10,poz+1)-n) + numbers.get(10* (int) Math.pow(10,poz));
        }
        else if(n == 4*Math.pow(10, poz)) {
            return numbers.get(5*((int) Math.pow(10,poz))-n) + numbers.get(5* (int) Math.pow(10,poz));
        }
        else {
            StringBuilder nToR = new StringBuilder();
            int oldValue = n, iter = 0;
            while (n>0) {
                if (n<10){
                    while(n>0) {
                        if (numbers.containsKey(n)){
                            nToR.insert(0, numbers.get(n * ((int) Math.pow(10,poz))));
                            n = 0;
                        }
                        else{
                            nToR.insert(0, numbers.get((int) Math.pow(10,poz)));
                            n--;
                        }
                    }
                    
                 }
                else{
                    n /= (int) Math.pow(10,poz); 
                }
            }
            return nToR.toString();
        }
    }

    public static String intToRoman(int num) {
        HashMap<Integer, String> numbers = symbolsToNumerals();
        StringBuilder romanNumber = new StringBuilder();

        if (numbers.containsKey(num)){ //it is not necessary to convert int to Integer
            return numbers.get(num);
        }
        else {
            int poz = 0;
            while (num > 0){
                int digit = num / (int) Math.pow(10, poz) % 10;
                romanNumber.insert(0, getOneValue(digit * (int) Math.pow(10, poz), poz, numbers));
        
                num -= digit * (int) Math.pow(10, poz);
                poz++;
            }
        }

        return romanNumber.toString();
    }

    public static void main(String[] args) {
        int value;

        do{
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter a decimal number. ");
            value = myObj.nextInt();
        }while (value < 1 || value >3999);
        
        
        String romanValue = intToRoman(value);

        System.out.println("decimal value: " + value + " is roman value: " + romanValue);
    }
        
}
