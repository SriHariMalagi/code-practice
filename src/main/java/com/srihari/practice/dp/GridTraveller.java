package com.srihari.practice.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public BigInteger findNumberOfPathsRecursive(int rows, int columns) {
        if(rows == 0 ||  columns == 0) {
            return BigInteger.ZERO;
        } else if(rows == 1 && columns == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger right = findNumberOfPathsRecursive(rows, columns-1);
            BigInteger down = findNumberOfPathsRecursive(rows-1, columns);
            return right.add(down);
        }
    }

    private BigInteger findNumberOfPathsMemoized(int rows, int columns, Map<String, BigInteger> memo) {
        String memoKey = String.format("%d,%d", rows, columns);
        if(rows == 0 ||  columns == 0) {
            return BigInteger.ZERO;
        } else if(rows == 1 && columns == 1) {
            return BigInteger.ONE;
        } else if(memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        } else {
            BigInteger right = findNumberOfPathsMemoized(rows, columns-1, memo);
            BigInteger down = findNumberOfPathsMemoized(rows-1, columns, memo);
            BigInteger result = right.add(down);
            memo.put(memoKey, result);
            return result;
        }
    }

    public BigInteger findNumberOfPathsMemoized(int rows, int columns) {
        Map<String, BigInteger> memo = new HashMap<>();
        return findNumberOfPathsMemoized(rows, columns, memo);
    }
}
