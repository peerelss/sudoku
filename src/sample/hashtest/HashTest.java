package sample.hashtest;

import java.util.*;

public class HashTest {

    public static void main(String[] arg) {
        calcIJ9(3, 0);
    }

    private static void calcIJ9(int i1, int j1) {
        TreeSet<Integer> set1 = new TreeSet<Integer>();
        TreeSet<Integer> set2 = new TreeSet<Integer>();
        TreeSet<Integer> set3 = new TreeSet<Integer>();
        set1.add(1);set1.add(4);
        set2.add(1);set2.add(8);
        set3.add(1);set3.add(4);
        //寻找set1,set2,set3中只出现过一次的数字
        int[] li={0,0,0,0,0,0,0,0,0};
        for(Integer integer:set1){
            li[integer]=li[integer]+1;
        }
        for(Integer integer:set2){
            li[integer]=li[integer]+1;
        }
        for(Integer integer:set3){
            li[integer]=li[integer]+1;
        }
        for(int i=0;i<li.length;i++){
            if(li[i]==1){
                System.out.println(" li = "+i);
            }
        }
    }
}
