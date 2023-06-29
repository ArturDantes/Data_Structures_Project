public class HashTable<K, V> {
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next; 
        // same as private Node<T> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        
        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 20;
    private Entry<K, V> table[];
    private int size;

    //
    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.setNext(table[index]);
        table[index] = newEntry;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                if (prev == null) {
                    table[index] = entry.getNext();
                } else {
                    prev.setNext(entry.getNext());
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.getNext();
        }
    }
    
    private int hash(K key) {
        int NumberOfhashCode = myHashCode(key);
        return Math.abs(NumberOfhashCode) % table.length;
    }

    private int myHashCode(K key) {
        if (key instanceof String) {
            return calculateStringHashCode((String) key);
        } else if (key instanceof Integer) {
            return calculateNumericHashCode(key);
        } else {
            // Handle other key types or throw an exception if unsupported
            throw new UnsupportedOperationException("Unsupported key type: " + key.getClass().getSimpleName());
        }
    }

    private int calculateStringHashCode(String key) {
        int sumOfAsciiCodes = 0;
        for (int i = 0; i < key.length(); i++) {
            sumOfAsciiCodes += (int) key.charAt(i);
        }
        return sumOfAsciiCodes;
    }

    private int calculateNumericHashCode(K key) {
        return ((Integer)key);
    }
}
