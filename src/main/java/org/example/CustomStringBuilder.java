package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStringBuilder {

    private int size;

    private char[] value;

    private final int defaultCapacity = 16;

    private int capacity = defaultCapacity;

    public CustomStringBuilder(char[] value) {
        if (value.length > defaultCapacity) {
            capacity = value.length;
        }
        this.value = new char[capacity];
        initializeValue(value);
        this.size = value.length;
        SnapshotStore.storage.add(new Snapshot(Arrays.copyOf(value,size)));
    }

    public CustomStringBuilder(String string) {
        if (string.length() > capacity) {
            capacity = string.length();
        }
        this.value = new char[capacity];
        initializeValue(string.toCharArray());
        this.size = string.length();
        SnapshotStore.storage.add(new Snapshot(Arrays.copyOf(value,size)));
    }

    public CustomStringBuilder() {
        this.value = new char[capacity];
        this.size = 0;
        SnapshotStore.storage.add(new Snapshot(Arrays.copyOf(value,size)));
    }


    public void append(String appender) {
        if (this.size + appender.length() > capacity) {
            this.value = increaseCapacity(this.value);
        }
        System.arraycopy(appender.toCharArray(), 0, this.value, size, appender.length());
        size += appender.length();
        SnapshotStore.version++;
        SnapshotStore.storage.add(new Snapshot(Arrays.copyOf(value,size)));
    }

    public void undo() {
        if (SnapshotStore.version > 0) {
            SnapshotStore.version--;
        }
        this.value = SnapshotStore.storage.get(SnapshotStore.version).getContent();
        this.size = SnapshotStore.getSize();
    }

    private void initializeValue(char[] value) {
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    private char[] increaseCapacity(char[] value) {
        capacity *= 2;
        char[] newArray = new char[capacity];
        System.arraycopy(value, 0, newArray, 0, value.length);
        return newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "[" + String.valueOf(value).substring(0, size) + "]";
    }


    private class Snapshot {

        private final char[] content;

        public Snapshot(char[] content) {
            this.content = content;
        }

        public char[] getContent() {
            return content;
        }
    }

    private static class SnapshotStore {

        private static final List<Snapshot> storage = new ArrayList<>();

        private static int version = 0;

        private static int getSize() {
            Snapshot snapshot = storage.get(version);
            for (int i = 0; i < snapshot.getContent().length; i++) {
                if (snapshot.getContent()[i] == '\u0000') {
                    return i;
                }
            }
            return snapshot.getContent().length;
        }

    }


}
