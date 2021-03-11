package chrvk.javaelementary.hw6.task2;

import java.util.Arrays;

public class MyHashSet implements MySet {

    private final MyHashMap map = new MyHashMap();

    @Override
    public boolean add(String value) {
        String PLACEHOLDER = "";
        return map.put(value, PLACEHOLDER) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(String value) {
        return map.remove(value) == null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(String value) {
        return map.contains(value);
    }

    @Override
    public String[] toArray() {
        String[] result = new String[map.size()];
        int index = 0;
        for (MyMap.Entry entry : map.toArray()) {
            result[index++] = entry.getKey();
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}