package Demo;

import java.util.*;

public class JAVA8 {
    interface Formula1{
        double calculate(int b);
        default double sqrt(int a){
            return Math.sqrt(a);
        }
    }

    public static void main(String[] args) {

        // 通过匿名内部类方式访问接口
        Formula1 formula = new Formula1() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };


        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.sqrt(16));           // 4.0



        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a, b) -> b.compareTo(a));

        System.out.println(names);



        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}