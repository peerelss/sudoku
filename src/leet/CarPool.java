package leet;

public class CarPool {

    public static void main(String[] args) {
        int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        int ca = 11;
        System.out.println(carPooling(trips, ca) + " ");
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] cars = new int[1000];
        for (int i = 0; i < trips.length; i++) {
            for (int k = trips[i][1]; k < trips[i][2]; k++) {
                cars[k] = cars[k] + trips[i][0];
                if (cars[k] > capacity) {
                    System.out.println("k = "+k+" i = "+i+" "+cars[k]);
                    return false;
                }
            }

        }
        return true;
    }
}
