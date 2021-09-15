package com.srihari.practice.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public BigInteger recursiveFibonacci(int n) {
        if(n <= 2) {
            return BigInteger.ONE;
        } else {
            return recursiveFibonacci(n-1).add(recursiveFibonacci(n-2));
        }
    }

    private BigInteger memoizedFibonacci(int n, Map<Integer, BigInteger> memo) {
        if(n <= 2) {
            return BigInteger.ONE;
        } else if(memo.containsKey(n)) {
            return memo.get(n);
        } else {
            BigInteger result = memoizedFibonacci(n-1, memo).add(memoizedFibonacci(n-2, memo));
            memo.put(n, result);
            return result;
        }
    }

    public BigInteger memoizedFibonacci(int n) {
        Map<Integer, BigInteger> memo = new HashMap<>();
        return memoizedFibonacci(n, memo);
    }
}
