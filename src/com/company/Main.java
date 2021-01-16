package com.company;

public class Main {

    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt("b5c0b187fe309af0f4d35982fd961d7e");

        long startTime = System.currentTimeMillis();

        String result = decrypt.bruteForce(4);

        long endTime = System.currentTimeMillis();

        System.out.println("Result: " + result);
        System.out.println("That took " + (double) (endTime - startTime) / 1000 + " seconds");
    }
}
