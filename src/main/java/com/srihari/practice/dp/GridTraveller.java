package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class GridTraveller {

    private static final Logger logger = LoggerFactory.getLogger(GridTraveller.class.getName());

    public static BigInteger findNumberOfPathsRecursive(int row, int column) {
        if(row == 0 ||  column == 0) {
            return BigInteger.ZERO;
        } else if(row == 1 && column == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger right = findNumberOfPathsRecursive(row, column-1);
            BigInteger down = findNumberOfPathsRecursive(row-1, column);
            return right.add(down);
        }
    }

    public static BigInteger findNumberOfPathsMemoized(int rows, int columns) {
        BigInteger[][] memo = new BigInteger[rows][columns];

        for(int i=0; i<rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 1-D Array case
                if (i == 0 || j == 0) {
                    memo[i][j] = BigInteger.ONE;
                } else {
                    BigInteger pathsPostMovingRight = memo[i][j-1];
                    BigInteger pathsPostMovingDown = memo[i-1][j];
                    memo[i][j] = pathsPostMovingDown.add(pathsPostMovingRight);
                }
            }
        }
        return memo[rows-1][columns-1];
    }
    public static void main(String[] args) {

        int rows = 18;
        int columns = 18;

        Timer.timed(() -> {
            BigInteger paths = findNumberOfPathsRecursive(rows, columns);
            logger.info("Recursive: Found {} paths to traverse for {}x{} grid", paths, rows, columns);
        });

        Timer.timed(() -> {
            BigInteger paths = findNumberOfPathsMemoized(rows, columns);
            logger.info("Memoized: Found {} paths to traverse for {}x{} grid", paths, rows, columns);
        });
    }
}
