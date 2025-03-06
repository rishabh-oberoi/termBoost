package com.company;
import java.io.*;
import java.util.*;

public class TestCaseGenerator {

    // Euclidean algorithm to find GCD
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Generate 1000+ test cases with varying values
    public static void generateTestCases(String filename, int count, int limitA, int limitN) throws IOException {
        Random rand = new Random();
        Set<String> testCases = new HashSet<>();

        while (testCases.size() < count) {
            long a = rand.nextInt(limitA) + 2;
            long b;
            do {
                b = rand.nextInt(limitA) + 2;
            } while (gcd(a, b) != 1);  // Ensure co-primality

            // Generate n with a mix of small, medium, and large values
            long n;
            int category = rand.nextInt(3);
            if (category == 0) {
                n = rand.nextInt(1_000) + 1;  // Small
            } else if (category == 1) {
                n = rand.nextInt(999_000) + 1_000;  // Medium
            } else {
                n = rand.nextInt(9_000_000) + 1_000_000;  // Large
            }

            testCases.add(a + " " + b + " " + n);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String test : testCases) {
                writer.write(test);
                writer.newLine();
            }
        }
        System.out.println("✅ Generated 1,000,000 test cases in " + filename);
    }

    public static void main(String[] args) {
        String filename = "src/com/company/test_cases.txt";
        try {
            generateTestCases(filename, 1000000, 100000, 10_000_000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
