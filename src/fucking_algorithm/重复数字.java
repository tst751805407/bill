package fucking_algorithm;

import java.util.HashMap;

public class 重复数字 {
    public static void FindNumsAppearOnce(int [] array,int num1, int num2) {
        HashMap<Integer,Integer>h=new HashMap<>();
        for (int i:array
             ) {
            if (h.containsKey(i)){
                h.remove(i);
            }else {
                h.put(i,0);
            }
        }
        System.out.println(h);

    }
    public static void main(String[] args) {
        int [] array={
                1,1,2,2,3,4
        };

        FindNumsAppearOnce(array,0,0);
    }

}
