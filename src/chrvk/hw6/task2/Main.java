package chrvk.hw6.task2;

public class Main {

    public static void main(String[] args) {

        MyMap myMap = new MyHashMap();
        System.out.println(myMap.isEmpty());
        myMap.put("1", "asdf");
        myMap.put("2", "qwert");
        myMap.put("3", "zxcv");
        myMap.put("1", "zzz");
        System.out.println(myMap);

        MySet set = new MyHashSet();
        set.add("asdf");
        set.add("qwer");
        set.add("zxcv");
        set.add("asdf");
        System.out.println(set.toString());

    }

}
