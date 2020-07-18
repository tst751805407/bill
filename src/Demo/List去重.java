package Demo;



import java.util.ArrayList;
import java.util.HashSet;

public class List去重 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        //双重循环去重
        System.out.println( removeDuplicate_2(list));

    }

    //1.循环list中所有的元素然后删除
    public static ArrayList removeDuplicate_1(ArrayList list){
        for(int i =0;i<list.size()-1;i++){
            for(int j=list.size()-1;j>i;j--){
                if(list.get(i).equals(list.get(j)))
                    list.remove(j);
            }
        }

        return list;
    }

    //2.利用hashSet剔除重复元素,但是是无序的
    public static ArrayList removeDuplicate_2(ArrayList list){
        HashSet set = new HashSet(list);
        //使用LinkedHashSet可以保证输入的顺序
        //LinkedHashSet<String> set2 = new LinkedHashSet<String>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    //3.利用list的contains方法去重
    public static ArrayList removeDuplicate_3(ArrayList list){
        ArrayList tempList = new ArrayList(list.size());
        for(int i=0;i<list.size();i++){
            if(!tempList.contains(list.get(i)))
                tempList.add(list.get(i));
        }
        return tempList;
    }
}
