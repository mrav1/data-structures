package com.ravi;

public class HashTable<K, V> {
    private HashEntry[] data = null;
    private int capacity;
    private int size;

    public HashTable() {
        this(100);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[capacity];
        this.size = 0;
    }

    public V get(K key) {
        int hash = calculateHash(key);
        if (data[hash] == null) {
            return null;
        } else {
            return (V) data[hash].getValue();
        }
    }

    public void put(K key, V value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry(key, value);
        size++;
    }

    public V delete(K key) {
        V value = get(key);
        if (value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
        }
        return value;
    }

    private int calculateHash(K key) {
        int hash = key.hashCode() % this.capacity;
        // To avoid hash collision
        while (data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    public int size() {
        return size;
    }

    private class HashEntry<K, V> {
        private K key;
        private V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
