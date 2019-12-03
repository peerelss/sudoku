package leet.leet_1;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1212));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x > Integer.MAX_VALUE) {
            return false;
        }
        int temp = x, result = 0;
        while (temp / 10 >= 1) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        result = result * 10 + temp ;
     //   System.out.println(result+" ");
        return result == x;

    }
}
