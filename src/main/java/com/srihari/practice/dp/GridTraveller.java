package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridTraveller.class.getName());

    public static BigInteger findNumberOfPathsRecursive(int rows, int columns) {
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

    public static BigInteger findNumberOfPathsMemoized(int rows, int columns, Map<String, BigInteger> memo) {
        String memoKey = String.format("%d,%d", rows, columns);
        if(memo == null) {
            memo = new HashMap<>();
        }

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
    public static void main(String[] args) {

        int rows = 18;
        int columns = 18;

        Timer.timed(() -> {
            BigInteger paths = findNumberOfPathsRecursive(rows, columns);
            LOGGER.info("Recursive: Found {} paths to traverse for {}x{} grid", paths, rows, columns);
        });

        Timer.timed(() -> {
            BigInteger paths = findNumberOfPathsMemoized(rows, columns, null);
            LOGGER.info("Memoized: Found {} paths to traverse for {}x{} grid", paths, rows, columns);
        });
    }
}
