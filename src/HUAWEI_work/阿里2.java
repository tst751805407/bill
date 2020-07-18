package HUAWEI_work;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 阿里2 {
    public static void main(String[] args) {
        int n,m,x;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        m=s.nextInt();
        x=s.nextInt();
        //城市数量，单项路数量，参加聚会的位置
        int[][]arr=new int[n][n];
        int a1,a2,num;
        for (int i=0;i<m;i++){
            a1=s.nextInt();
            a2=s.nextInt();
            num=s.nextInt();
            arr[a1-1][a2-1]=num;
        }
        System.out.println();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        x--;
        int sum=0;
        PriorityQueue q=new PriorityQueue();
        for (int i=0;i<n;i++){
            int hang=0;
            for (int j=0;j<n;j++){


            }
            System.out.print(hang+" ");
        }


    }
}



/*


回的方案只要通过2节点，返回他的所有广度优先遍历结果
就能得到所有回来的最短路径

然后将两个最短路径算一下就可以得到最大的值了


主要考察的就是图的遍历
1: 2(4), 3(2), 4(7)2: 1(1), 3(5)3: 1(2), 4(4)4: 2(3)

1的所有路径（广度优先遍历）首先将所有与1向连的数据push为一个数组[2, 3, 4][2: 4, 3 -> 4 -> 2: 9, 4 -> 2: 10] -> [4, 9, 10]最短路径是4
3的所有路径（广度优先遍历）首先将所有与3向连的数据push为一个数组[1, 4][1 -> 2: 6, 4 -> 2: 7]最短路径是6
4的所有路径（广度优先遍历）首先将所有与4向连的数据push为一个数组[2][2: 3]最短路径是6


4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
 */
