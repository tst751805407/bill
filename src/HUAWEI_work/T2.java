package HUAWEI_work;

import java.util.HashMap;
import java.util.Map;

public class T2 {
    public static final int N=3;
    public static void main(String[] args) {
        int x[][]={
                {0,2,0,0,0,9,0,1,0,0},
                {5,0,6,0,0,0,3,0,9,0},
                {0,8,0,5,0,2,0,6,0,0},
                {0,0,5,0,7,0,1,0,0,0},
                {0,0,0,2,0,8,0,0,0,0},
                {0,0,4,0,1,0,8,0,0,0},
                {0,5,0,8,0,7,0,3,0,0},
                {7,0,2,3,0,0,4,0,5,0},
                {0,4,0,0,0,0,0,7,0,0},
        };

        function(x,0,0);

    }
    private static void function(int[][] x, int r, int c) {
        if (r>=x.length) {
            show(x);
            return;
        }
        if (c==0&&(r==x.length/N||r==x.length/N*2||r==x.length)) {
            if (!checkedbox(x,r)) {
                return;
            };

        }
        if (c>=x.length) {
            function(x, r+1, 0);
            return;
        }

        if (x[r][c]==0) {
            for (int i = 1; i <= x.length; i++) {
                if (checked(x,r,c,i)) {
                    x[r][c]=i;
                    function(x, r, c+1);
                    x[r][c]=0;
                }
            }
        }else{
            function(x, r, c+1);
        }
    }
    private static boolean checkedbox(int[][] x, int r) {
        for (int k = 0; k < x.length; k+=x.length/N) {
            Map<Integer, Integer> map=new HashMap<>();
            for (int i = r-N; i < r; i++) {
                for (int j = k; j < k+x.length/N; j++) {
                    if (map.containsKey(x[i][j])) {
                        return false;
                    }
                    map.put(x[i][j], 1);
                }
            }

        }
        return true;
    }

    private static boolean checked(int[][] x, int r, int c, int i) {
        for (int j = 0; j < x.length; j++) {
            if (x[j][c]==i) {
                return false;
            }
            if (x[r][j]==i) {
                return false;
            }
        }
        return true;
    }

    private static void show(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print("{");
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j]+",");
            }
            System.out.println("}");
        }
        System.out.println();
    }

}
