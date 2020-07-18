import java.util.Arrays;
import java.util.Scanner;


/**
 *解决思路：
 *      将桌子和顾客分别抽象成两个类，对它们进行排序，然后进行二分查找
 **/

/**
 * 桌子类
 */
class Table implements Comparable {

    // 可容纳人数
    public int number;
    // 是否被占用
    public boolean flag;

    public Table(int number) {
        this.number = number;
        this.flag = false;
    }

    /**
     * 将Table按升序排列
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Table t = (Table) o;
        if (this.number > t.number) {
            return 1;
        } else if (this.number == t.number) {
            return 0;
        } else {
            return -1;
        }
    }
}


/**
 * 客户类
 */
class Customer implements Comparable {

    // 人数
    public int number;
    // 预期消费
    public int spent;
    // 是否吃过了
    public boolean flag;

    public Customer() {}


    public Customer(int number, int spent) {
        this.number = number;
        this.spent = spent;
        flag = false;
    }


    /**
     * 将消费最高的排最前，碰到消费相同的，按用餐人数升序排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Customer t = (Customer)o;
        if (this.spent > t.spent) {
            return -1;
        } else if (this.spent < t.spent) {
            return 1;
        } else {
//            return this.number>=t.number ? 1 : 0;
            if (this.number > t.number) {
                return 1;
            } else if (this.number < t.number) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}


public class mmm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 桌子数
        int n = scanner.nextInt();
        // 客人批数
        int m = scanner.nextInt();
        // 桌子最大容纳数量
        Table[] tables = new Table[n];
        // 客人数组
        Customer[] customers = new Customer[m];

        // 存储桌子容量
        for (int i = 0; i < n; i++) {
            tables[i] = new Table(scanner.nextInt());
        }
        // 存储客人信息
        for (int i = 0; i < m; i++) {
            customers[i] = new Customer(scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();


        // 总消费
        long sumSpent = 0;
        // tables升序排列
        Arrays.sort(tables);
        // customers消费降序，消费相同，人数升序排列
        Arrays.sort(customers);
        int count = 0;


        for (int i = 0; i < m; i++) {
            // 桌子坐满了
            if (count == n) {
                break;
            }
            int l = 0;
            int r = n-1;
            while (l <= r) {
                int mid = l+(r-l)/2;

                if (tables[mid].number < customers[i].number) {
                    l = mid+1;
                } else if (tables[mid].number > customers[i].number) {

                    r = mid-1;
                } else {
                    if (!tables[mid].flag) {
                        sumSpent += customers[i].spent;
                        tables[mid].flag = true;
                        count++;
                        break;
                    } else{

                        int temp = mid-1;

                        while (temp>=0
                                && tables[temp].flag==true
                                && tables[temp].number==tables[mid].number) {
                            temp--;
                        }

                        if(temp>=0
                                && tables[temp].flag==false
                                && tables[temp].number == tables[mid].number){
                            sumSpent += customers[i].spent;
                            tables[temp].flag = true;
                            count++;
                            break;
                        }

                        // 向前找没找到，这时向后找，哪怕浪费座位
                        while(mid<=n-1
                                && tables[mid].flag==true) {
                            mid++;
                        }

                        // 向后也找不到，放弃这个客人
                        if(mid > n-1) {
                            break;
                        }

                        // 找到了座位
                        sumSpent += customers[i].spent;
                        tables[mid].flag = true;
                        count++;
                        break;
                    }
                }
            }
            if(l>r){
                // 向后找
                while(l<=n-1
                        && tables[l].flag==true) {
                    l++;
                }
                if(l<=n-1){
                    sumSpent += customers[i].spent;
                    tables[l].flag = true;
                    count++;
                }

            }
        }
        System.out.println(sumSpent);

    }
}

