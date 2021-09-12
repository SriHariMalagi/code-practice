package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fibonacci.class.getName());

    private static BigInteger recursiveFibonacci(int n) {
        if(n <= 2) {
            return BigInteger.ONE;
        } else {
            return recursiveFibonacci(n-1).add(recursiveFibonacci(n-2));
        }
    }

    private static BigInteger memoizedFibonacci(int n, Map<Integer, BigInteger> memo) {
        if(memo == null) {
            memo = new HashMap<>();
        }
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

    public static void main(String[] args) {
        // Fibonacci Series Ex: 1,1,2,3,5,8,13,21.....
        int input = 50;
        Timer.timed(() -> {
            BigInteger result = recursiveFibonacci(input);
            LOGGER.info("Recursive function: Fib({}) = {}", input, result);
        });
        Timer.timed(() -> {
            BigInteger result = memoizedFibonacci(input, null);
            LOGGER.info("Memoized function: Fib({}) = {}", input, result);
        });
    }

}
