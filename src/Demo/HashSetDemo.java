package Demo;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        set.add(123);
        set.add(456);
        System.out.println(set);

        set.remove(123);
        System.out.println(set);

        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}

