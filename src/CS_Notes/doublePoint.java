package CS_Notes;

import java.util.Arrays;
import java.util.HashSet;

public class doublePoint {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length<2)return null;
        int small=0,big=numbers.length-1;
        while (small<big){
            int sum=numbers[small]+numbers[big];
            if (sum==target)return new int[]{small+1,big+1};
            if (sum<target) small++;
            if (sum>target) big--;
        }
        return null;
    }
    public boolean judgeSquareSum(int target) {
        if (target<0)return false;
        int i=0,j=(int)Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    private final static HashSet<Character>vowel=new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7,8,9};
        int[]b=twoSum(a,15);
        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }

    }
}
