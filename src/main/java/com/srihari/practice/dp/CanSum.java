package com.srihari.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public boolean recursiveCanSum(int total, int[] availableNumbers) {
        if(total == 0) {
            return true;
        } else if(total < 0) {
            return false;
        } else {
            return Arrays.stream(availableNumbers).anyMatch(
                    availableNumber -> recursiveCanSum(total-availableNumber, availableNumbers)
            );
        }
    }

    private boolean memoizedCanSum(int total, int[] availableNumbers, Map<Integer, Boolean> memo) {
        if(total == 0){
            return true;
        } else if(total < 0) {
            return false;
        } else if(memo.containsKey(total)) {
            return memo.get(total);
        } else {
            return Arrays.stream(availableNumbers).anyMatch(
                    availableNumber -> {
                        boolean result = memoizedCanSum(total-availableNumber, availableNumbers, memo);
                        memo.put(total, result);
                        return result;
                    }
            );
        }
    }

    public boolean memoizedCanSum(int total, int[] availableNumbers) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return memoizedCanSum(total, availableNumbers, memo);
    }
}
