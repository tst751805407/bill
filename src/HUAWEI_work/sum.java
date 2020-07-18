package HUAWEI_work;

import java.util.ArrayList;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class sum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int len=array.length;
        int num=0,start=0,end=len-1;
        while (start<end){
            if (array[start] + array[end] == sum) {
                list.add(array[start]);
                list.add(array[end]);
                return list;
            }
            if (array[start] + array[end] > sum) {
                end--;
            }
            if (array[start] + array[end] < sum) {
                start++;
            }

        }

        return list;

    }
    public static void main(String[] args) {
        int [] array={1,2,3,4,5,6,7,8,9,12};
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr=FindNumbersWithSum(array,12);
        System.out.println(FindNumbersWithSum(array,12));
    }
}
