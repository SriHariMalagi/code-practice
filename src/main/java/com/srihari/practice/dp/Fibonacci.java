package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Logger logger = LoggerFactory.getLogger(Fibonacci.class.getName());

    private static BigInteger recursiveFibonacci(int n) {
        if(n <= 2) {
            return BigInteger.ONE;
        } else {
            return recursiveFibonacci(n-1).add(recursiveFibonacci(n-2));
        }
    }

    private static BigInteger memoizedFibonacci(int n) {
        Map<Integer, BigInteger> memo = new HashMap<>();
        memo.put(0, BigInteger.ONE);
        memo.put(1, BigInteger.ONE);
        for(int i=2; i<n; i++) {
            BigInteger result = memo.get(i-1).add(memo.get(i-2));
            memo.put(i, result);
        }
        return memo.get(n-1);
    }

    public static void main(String[] args) {
        // Fibonacci Series Ex: 1,1,2,3,5,8,13,21.....
        int input = 50;
        Timer.timed(() -> {
            BigInteger result = recursiveFibonacci(input);
            logger.info("Recursive function: Fib({}) = {}", input, result);
        });
        Timer.timed(() -> {
            BigInteger result = memoizedFibonacci(input);
            logger.info("Memoized function: Fib({}) = {}", input, result);
        });
    }

}
