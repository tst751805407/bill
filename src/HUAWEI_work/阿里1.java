package HUAWEI_work;

import java.util.Scanner;



public class 阿里1 {
    public static void main(String[] args) {
        int num,n;

        Scanner s=new Scanner(System.in);

        num=s.nextInt();
        int[] arr=new int[num+1];
        int[] result=new int[num+1];

        for (int i=1;i<num+1;i++){
            n=s.nextInt();
            arr[i]=n;
            result[i]++;
            if (n>0&&n<i){
                result[arr[i]]++;
            }

        }

        for (int i=1;i<num+1;i++){
            System.out.println(result[i]);
        }
    }
}


/*
4
0 1 1 1

4 1 1 1


4
2 1 1 1

4 1 1 1


4
3 2 2 2

1 4 1 1

 */