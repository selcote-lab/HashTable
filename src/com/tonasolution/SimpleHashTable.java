package com.tonasolution;

public class SimpleHashTable {

    private StoreEmployee[] hashTable;

    public SimpleHashTable() {
        hashTable = new StoreEmployee[10];
    }

    public void put(String key, Employee employee){

        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {

            int stopIndex = hashedKey;

            if (hashedKey == hashTable.length - 1){
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if (occupied(hashedKey)) {

            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else {
            hashTable[hashedKey] = new StoreEmployee(key, employee);
        }
    }

    public Employee get(String key) {

        int hashedKey = findKey(key);

        if (hashedKey == -1) return null;

        return hashTable[hashedKey].employee;
    }

    public Employee remove(String key) {

        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;

        return employee;
    }

    private int findKey(String key) {

        int hashedKey = hashKey(key);

        if (
                hashTable[hashedKey] != null &&
                hashTable[hashedKey].key.equals(key)
        ) {
            return hashedKey;
        }

        int stopIndex = hashedKey;

        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (
                hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                !hashTable[hashedKey].key.equals(key)

        ) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if (
                hashTable[hashedKey] != null &&
                hashTable[hashedKey].key.equals(key)
        ) {
            return hashedKey;
        }

        return -1;
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public boolean occupied(int index) {
          return hashTable[index] != null;
    }

    public void print() {

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                System.out.println("Empty");
            }
            else {
                System.out.println("Position "+ i + "->" + hashTable[i].employee);
            }

        }
    }

}
