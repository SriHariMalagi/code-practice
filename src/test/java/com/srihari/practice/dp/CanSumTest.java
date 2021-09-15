package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CanSumTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanSumTest.class.getName());

    private final CanSum sut;

    public CanSumTest() {
        this.sut = new CanSum();
    }

    @Test
    public void testRecursiveCanSum() {
        int totalSum = 300;
        int[] availableNumbers = new int[] {7,14};
        AtomicReference<Boolean> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.recursiveCanSum(totalSum, availableNumbers));
            String userText = result.get()? "can": "can't";
            LOGGER.info("Recursive: We {} sum availableNumbers: {} to get a total of {}",
                    userText, availableNumbers, totalSum);
        });

        assertEquals(
                String.format("Expected false for canSum(%s, %s)", totalSum, Arrays.toString(availableNumbers)),
                false,
                result.get()
        );

        LOGGER.info("Recursive function to check whether we can sum {} using {} took {} milliseconds to execute.",
                totalSum, availableNumbers, executionTime.toMillis());
    }

    @Test
    public void testMemoizedCanSum() {
        int totalSum = 300;
        int[] availableNumbers = new int[] {7,14};
        AtomicReference<Boolean> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.memoizedCanSum(totalSum, availableNumbers));
            String userText = result.get()? "can": "can't";
            LOGGER.info("Memoized: We {} sum availableNumbers: {} to get a total of {}",
                    userText, availableNumbers, totalSum);
        });

        assertEquals(
                String.format("Expected false for canSum(%s, %s)", totalSum, Arrays.toString(availableNumbers)),
                false,
                result.get()
        );

        LOGGER.info("Recursive function to check whether we can sum {} using {} took {} milliseconds to execute.",
                totalSum, availableNumbers, executionTime.toMillis());
    }
}