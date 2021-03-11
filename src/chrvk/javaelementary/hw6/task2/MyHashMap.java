package chrvk.javaelementary.hw6.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap implements MyMap {

    private static class Entry implements MyMap.Entry {

        String key;
        String value;
        int hashCode;
        Entry next;

        public Entry(String key, String value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private int size = 0;
    private Entry[] table = new Entry[16];
    private final double loadFactor = 0.75;
    private double threshold = table.length * loadFactor;

    @Override
    public void clear() {
        size = 0;
        table = new Entry[16];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String put(String key, String value) {
        String result = putInternal(key, value);
        if (result == null) {
            size++;
        }
        if (size > threshold) {
            resize();
        }
        return result;
    }

    private String putInternal(String key, String value) {
        Entry newEntry = new Entry(key, value, key.hashCode());
        int position = newEntry.hashCode % table.length;
        if (table[position] != null) {
            Entry tmp = table[position];
            while (tmp != null) {
                if (tmp.key.equals(key)) {
                    String oldValue = tmp.value;
                    tmp.value = value;
                    return oldValue;
                }
                tmp = tmp.next;
            }
            newEntry.next = table[position];
        }
        table[position] = newEntry;
        return null;
    }

    private void resize() {
        Entry[] arr = toArray();
        table = new Entry[table.length * 2];
        threshold = loadFactor * table.length;
        for (Entry entry : arr) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean contains(String key) {
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                if (tmpEntry.key.equals(key)) {
                    return true;
                }
                tmpEntry = tmpEntry.next;
            }
        }
        return false;
    }

    @Override
    public String get(String key) {
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                if (tmpEntry.key.equals(key)) {
                    return entry.value;
                }
                tmpEntry = tmpEntry.next;
            }
        }
        return null;
    }

    @Override
    public String remove(String key) {
        String result = null;
        for (int i = 0; i < table.length; i++) {
            Entry tmpEntry = table[i];
            while (tmpEntry != null) {
                if (tmpEntry.key.equals(key)) {
                    result = table[i].value;
                    table[i] = table[i + 1];
                    size--;
                }
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }

    @Override
    public Set<MyMap.Entry> entrySet() {
        Set<MyMap.Entry> result = new HashSet<>();
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                result.add(tmpEntry);
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }


    @Override
    public Entry[] toArray() {
        Entry[] result = new Entry[size];
        int index = 0;
        for (Entry tmp : table) {
            while (tmp != null) {
                result[index] = tmp;
                tmp = tmp.next;
                index++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
