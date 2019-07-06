package leet;

public class TwoSum {
    public static void main(String[] args) {
        int[] nu = {2, 9, 7, 11, 15};
        int tar = 18;
        twoSum(nu, tar);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    System.out.println(i + ", " + j);
                    return result;
                }
            }
        }
        return new int[0];
    }
}
