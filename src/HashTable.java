import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

//TODO:
// - write tests
// - refactoring: remove and add entry
// - write other methods?
// - iterator

public class HashTable<K, V> {

    private Entry<K, V>[] table;
    private int size = 0;

    public HashTable() {
        table = new Entry[16];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = table[hash(key) & table.length - 1];
        if (entry == null) {
            table[hash(key) & table.length - 1] = new Entry<>(hash(key), key, value);
            size++;
        } else if (entry.key == key || entry.key.equals(key)) {
            entry.key = key;
            entry.value = value;
        } else {
            addEntry(entry, new Entry<>(hash(key), key, value));
        }

    }

    public V get(K key) {
        Entry<K, V> entry = findEntryByKey(table[hash(key) & table.length - 1], key);
        return entry != null ? entry.value : null;

    }

    public V remove(K key) {
        Entry<K, V> entry = table[hash(key) & table.length - 1];
        if (entry != null) {
            if (entry.key == key || entry.key.equals(key)) {
                table[entry.hash & table.length - 1] = entry.next;
                size--;
                return entry.value;
            } else {
                entry = deleteEntryByKey(entry, key);
                return entry != null ? entry.value : null;
            }
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(K key) {
        Entry<K, V> entry = findEntryByKey(table[hash(key) & table.length - 1], key);
        return entry != null && entry.key.equals(key);
    }

    private Entry<K, V> deleteEntryByKey(Entry<K, V> firstEntry, K key) {
        Entry<K, V> entry = firstEntry;
        Entry<K, V> previousEntry;
        do {
            previousEntry = entry;
            entry = entry.next;

        } while (entry != null && !entry.key.equals(key));
        if (entry != null) {
            previousEntry.next = entry.next;
            size--;
            return entry;
        } else {
            return null;
        }
    }

    private void addEntry(Entry<K, V> firstEntry, Entry<K, V> newEntry) {
        Entry<K, V> entry = firstEntry;
        for (; ; ) {
            if (entry.next != null) {
                entry = entry.next;
            } else break;
        }
        entry.next = newEntry;
        size++;
    }


    private Entry<K, V> findEntryByKey(Entry<K, V> entry, K key) {
        if (entry == null || entry.key == key || entry.key.equals(key)) {
            return entry;
        }

        do {
            entry = entry.next;
        } while (entry != null && !entry.key.equals(key));

        return entry;
    }

    public static class Entry<K, V> {
        private int hash;
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    private int hash(K key) {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(table).filter(Objects::nonNull).map(Entry::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
