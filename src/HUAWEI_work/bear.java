package HUAWEI_work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class bear {
    public static class Bear implements Comparable<Bear> {
        private int hungry;
        public int  fight;
        public Bear(int fight,int hungry){
            this.fight=fight;
            this.hungry=hungry;
        }

        public int getHungry() {
            return hungry;
        }

        public int getFight() {
            return fight;
        }
        @Override
        public int compareTo(Bear o) {
            if (this.fight>o.fight){
                return -1;
            }else if (this.fight==o.fight){
                return 0;
            }else {
                return 1;
            }


        }
    }
    //    public static class descComparator implements Comparator<Bear> {
//        public int compare(Bear p1, Bear p2) {
//            return p1.fight != p2.fight ? p2.fight - p1.fight : p1.hungry - p2.hungry;
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        Bear[]Bears=new Bear[n];
        int[] sugar=new int[m];
        HashMap<Integer, Bear> map = new HashMap<>();
        int fight,hungry;
        for (int i=0;i<m;i++){
            sugar[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){

            fight=scanner.nextInt();
            hungry=scanner.nextInt();
            Bears[i]=new Bear(fight,hungry);
            map.put(i,Bears[i]);
        }
        Arrays.sort(Bears);
        Arrays.sort(sugar);
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (sugar[j] != -1 && Bears[i].hungry - sugar[j] >= 0) {
                    Bears[i].hungry -= sugar[j];
                    sugar[j] = -1; //吃完糖将其置为-1
                }
            }
        }
        //打印结果
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(i).hungry);
        }


    }
}
