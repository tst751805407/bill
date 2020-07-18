import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static class zongzi {
        int a1,b1,c1,d1;

        public int getA1() {
            return a1;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public int getB1() {
            return b1;
        }

        public void setB1(int b1) {
            this.b1 = b1;
        }

        public int getC1() {
            return c1;
        }

        public void setC1(int c1) {
            this.c1 = c1;
        }

        public int getD1() {
            return d1;
        }

        public void setD1(int d1) {
            this.d1 = d1;
        }
        public zongzi(int a1,int b1,int c1,int d1){
            this.a1=a1;
            this.b1=b1;
            this.c1=c1;
            this.d1=d1;
        }

    }
    public static class zongziCompartor implements Comparator<zongzi>
    {
        @Override
        public int compare(zongzi o1, zongzi o2) {
            return o2.getD1()-o1.getD1();
        }
    }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n, m,c0,d0;
            n = in.nextInt();
            m = in.nextInt();
            c0 =in.nextInt();
            d0 =in.nextInt();
            zongzi[]zongzis=new zongzi[m];
            int money=0;
            for (int i = 0; i < m; i++) {
                int a1,b1,c1,d1;
                a1=in.nextInt();
                b1=in.nextInt();
                c1=in.nextInt();
                d1=in.nextInt();
                zongzis[i]=new zongzi(a1,b1,c1,d1);
            }
            // n面粉
            System.out.println(zongzis[0].getD1());
            Arrays.sort(zongzis,new zongziCompartor());
            System.out.println(zongzis[0].getD1());
            for (int i = 0; i < m; i++) {
                while (zongzis[i].getA1()>=zongzis[i].getB1()){
                    //可以做粽子
                    if (n>zongzis[i].getC1()){
                        n=n-zongzis[i].getC1();
                        money+=zongzis[i].getD1();
                        int xian=zongzis[i].getA1()-zongzis[i].getB1();
                        zongzis[i].setA1(xian);
                    }else {
                        break;
                    }
                }
            }
            while (n>=c0){
                n=n-c0;
                money+=d0;
            }

            System.out.println(money);


    }


}
//3 5 2 4 2 1 3 3 5 3 7 5 9 1 10

/*

Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        System.out.println(n+m);

10 2 1 1
6 3 2 50
8 2 1 10

10 2 1 1
8 2 1 10
6 3 2 50
 */