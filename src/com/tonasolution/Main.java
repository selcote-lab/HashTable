package com.tonasolution;

public class Main {

    public static void main(String[] args) {

        Employee zouhaire = new Employee("zouhaire", "elakioui", 123);
        Employee jack = new Employee("jack", "ali", 1234);
        Employee kali = new Employee("kali", "maeckel", 12345);
        Employee smith = new Employee("Mary", "smith", 12345);

        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.put("Zouhaire", zouhaire);
        simpleHashTable.put("Jack", jack);
        simpleHashTable.put("Kalii", kali);
        simpleHashTable.put("smith", kali);

        simpleHashTable.print();

        System.out.println("Retrieve key smith " + simpleHashTable.get("smith"));
    }
}
