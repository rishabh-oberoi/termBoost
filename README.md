# TermBoost

This repository contains the research code accompanying the paper **[my title: still need to decide]**. The code implements and benchmarks different approaches for finding the `n`-th smallest integer divisible by either `a` or `b` but not both, given that `a` and `b` are co-primes. The key focus is on the efficiency of a **binary search approach**(existing) versus a **formula-based approach**(novel).

## Problem Statement
Given two positive integers `a` and `b`, and an integer `n`, the task is to find the `n`-th positive integer that is divisible by either `a` or `b`, but not both.

## Constraints [for the problem]
- `a`, `b`, and `n` are Integers
- `a` and `b` are co-primes, i.e., they don't have any common factors other than `1`.
- `a`, `b` > 1
- `n` > 0
> **Note: In the solution, we enforce `a` < `b` in the driver code, so the algorithm assumes this constraint as well.**

## Constraints [used for benchmarking]
The test cases are generated with the following constraints:
- `2 ≤ a, b ≤ 100,000`
- `gcd(a, b) = 1` (co-prime values only)
- `1 ≤ n ≤ 10,000,000`
- The test cases cover a mix of small (`1 ≤ n ≤ 1,000`), medium (`1,000 ≤ n ≤ 1,000,000`), and large (`1,000,000 ≤ n ≤ 10,000,000`) values.

## Approaches Implemented
1. **Binary Search Approach**
   - Uses binary search to efficiently locate the `n`-th valid number.
   - Complexity: `O(log(N) * log(A + B))`
   
2. **Formula-Based Approach**
   - A direct computation formula based on integer division and modular arithmetic.
   - Complexity: `O(1)` in most cases.

## Benchmarking Results
We generated **1,000,000** test cases and compared execution times:

| Approach            | Execution Time (ms) |
|---------------------|---------------------|
| **Binary Search**  | 1477.34 ms          |
| **Formula-Based**  | 70.78 ms            |

### Observations
- The **formula-based approach** is significantly faster, as expected, due to its constant-time complexity.
- The **binary search approach** performs well but is slower due to iterative searching.
- Both methods yield correct results across all test cases.

## Usage
### Running the Benchmark
Ensure you have Java installed and then run:
```sh
javac Main.java && java Main
```
This will execute the benchmark using the generated test cases.

### Generating Test Cases
To generate test cases, run:
```sh
javac TestCaseGenerator.java && java TestCaseGenerator
```
This will create `test_cases.txt` with 1,000,000 cases.

## Disclaimer
This repository contains research code accompanying the paper **[Paper Title]**. It is provided for reference and reproducibility but is **not licensed for public use or modification**.

If you use this work in your research, please cite the paper accordingly.

---
