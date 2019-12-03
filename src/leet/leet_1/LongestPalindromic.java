package leet.leet_1;

public class LongestPalindromic {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcacb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int sLength = s.length();
        int max = 0, index = 0;//字符串开始位置
        for (int i = 0; i < sLength - 1; i++) {
            int getL = getLongB1(s, i);
            if (i + 1 < sLength && (s.substring(i, i + 1).equals(s.substring(i + 1, i + 2)))) {
                int getL2 = getLongB2(s, i, i + 1);
                if(max<getL2){
                    max=getL2;
                    index=i-max/2+1;
                    System.out.println(index + " index ");
                }
            }
            if(max<getL){
                max=getL;
                index=i-max/2;
                System.out.println(index + " index ");
            }

            System.out.println(max + " 最大 ");
        }
        return s.substring(index,index+max);
    }

    public static int getLongB1(String s, int i) {
        int j = 0;
        while (i + j + 1 <= s.length() && s.substring(i - j, i - j + 1).equals(s.substring(i + j, i + j + 1))) {
            j++;
            if (i + j > s.length() || i - j < 0) {
                break;
            }
        }
        return j * 2 - 1;
    }

    public static int getLongB2(String s, int i, int k) {
        int j = 0;
        while (k + j + 1 <= s.length() && s.substring(i - j, i - j + 1).equals(s.substring(k + j, k + j + 1))) {
            j++;
            if (i + j > s.length() || i - j < 0) {
                break;
            }
        }
        return j * 2 ;
    }

}
