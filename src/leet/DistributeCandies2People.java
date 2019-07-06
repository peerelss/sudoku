package leet;

/*
    对于这个问题，相当于求出给了多少 M 轮糖果，并且最后一轮停在 K 手上即可。
    1，假设有N个孩子，则第一轮需要n*(n+1)/2 =S 个糖果；
        第二轮需要 S+n*n;第三轮需要 S+n*n*2个。第m轮需要 S+n*n*(m-1)个
    2 , 假设完整进行了m-1轮。第m轮不能完全进行,停留在K手里。则
        第k-1 个孩子完整拿到了糖，剩余 J 个糖都留在K手里。
* */
public class DistributeCandies2People {
    public static void main(String[] args) {
        int[] result = distributeCandies(28, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int m_circle = findM(candies, num_people);
        int m = m_circle / num_people;//完整m个循环
        int k = m_circle % num_people;//最后停在第k个哪里。
        int[] result = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            if (i < k) {
                result[i] = sum(m + 1, num_people, i);
            }
            if (i > k) {
                result[i] = sum(m, num_people, i);
            }
        }
        result[k] = findK(m_circle, candies)+sum(m, num_people, k);
        return result;
    }

    // m_c 进行了完成m_c次循环，总共num个人，当前第i人
    public static int sum(int m_c, int num_people, int i) {
        if (m_c == 0) {
            return 0;
        }
        return (i + 1 + (m_c - 1) * num_people + i + 1) * m_c / 2;
    }

    public static int findK(int m, int num) {
        return num - m * (m + 1) / 2;
    }

    public static int findM(int c, int num) {
        for (int m = 0; ; m++) {
            if (m * (m + 1) / 2 <= c && c <= (m + 1) * (m + 2) / 2) {
                return m;
            }
        }
    }

}
