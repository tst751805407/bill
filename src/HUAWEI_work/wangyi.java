package HUAWEI_work;

import java.util.HashMap;
import java.util.Scanner;

public class wangyi {
    public static void main(String[] args) {
        int n,m;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        int a1[][]=new int[n][n];
        int a2[][]=new int[n][n];

        for (int i=0;i<n;i++){
            m=s.nextInt();
            for (int j=0;j<n;j++){
                a1[i][j]=s.nextInt();
            }
        }
        for (int i=0;i<n;i++){
            m=s.nextInt();
            for (int j=0;j<n;j++){
                a2[i][j]=s.nextInt();
            }
        }
        int out[][]=new int[n][2];
        HashMap<Integer,Integer> h=new HashMap();
        for (int i=0;i<n;i++){
            out[i][0]=i+1;
            if (!h.containsValue(a1[i][1])){
                out[i][1]=a1[i][0];
                h.put(i+1,out[i][1]);
            }
        }
        for (int i=1;i<n+1;i++){
            //老用户 i
            //System.out.println(out[i][1]);
            if (!h.containsValue(i)){
                //不存在老用户
                for (int k=0;k<n;k++){
                    if (!h.containsKey(a2[i-1][k])){
                        int x=a2[i-1][k]-1;
                        //System.out.println(x+"hh");
                        //不存在新用户
                        out[x][1]=i;
                        h.put(x+1,i);
                    }
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                System.out.print(out[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println(h);

    }
}

