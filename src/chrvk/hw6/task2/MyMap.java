package chrvk.hw6.task2;

import java.util.Set;

public interface MyMap {

    interface Entry {
        String getKey();

        String getValue();

        String setValue(String value);
    }

    String put(String key, String value);

    String get(String key);

    boolean contains(String key);

    void clear();

    int size();

    String remove(String key);

    Set<Entry> entrySet();

    boolean isEmpty();

    Entry[] toArray();

}