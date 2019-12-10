package com.tonasolution;

public class Main {

    public static void main(String[] args) {

        Employee zouhaire = new Employee("zouhaire", "elakioui", 123);
        Employee jack = new Employee("jack", "ali", 1234);
        Employee kali = new Employee("kali", "maeckel", 12345);
        Employee mary = new Employee("Mary", "smith", 12345);

        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.put("zouhaire", zouhaire);
        simpleHashTable.put("jack", jack);
        simpleHashTable.put("kali", kali);
        simpleHashTable.put("mary", mary);

        simpleHashTable.print();

        System.out.println("Retrieve key  kali" + simpleHashTable.get("mary"));

        System.out.println("Deleting ---> ");
        simpleHashTable.remove("mary");
        simpleHashTable.remove("jack");
        simpleHashTable.print();
    }
}
