package com.srihari.practice.dp;

import com.srihari.practice.dp.utils.Timer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciTest.class.getName());

    private final Fibonacci sut;

    public FibonacciTest() {
        this.sut = new Fibonacci();
    }

    @Test
    public void testRecursiveFibonacci() {
        int input = 50;
        BigInteger expectedOutput = BigInteger.valueOf(12586269025L);
        AtomicReference<BigInteger> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.recursiveFibonacci(input));
            LOGGER.info("Recursive function: Fib({}) = {}", input, result);
        });

        assertEquals(
                String.format("Expected right value for fib(%d)=%s. But found: %s", input, expectedOutput, result.get()),
                expectedOutput,
                result.get()
        );

        LOGGER.info("Recursive function for fib({}) took {} milliseconds to execute.", input, executionTime.toMillis());
    }

    @Test
    public void testMemoizedFibonacci() {
        int input = 50;
        BigInteger expectedOutput = BigInteger.valueOf(12586269025L);
        AtomicReference<BigInteger> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.memoizedFibonacci(input));
            LOGGER.info("Memoized function: Fib({}) = {}", input, result);
        });

        assertEquals(
                String.format("Expected right value for fib(%d)=%s. But found: %s", input, expectedOutput, result),
                expectedOutput,
                result.get()
        );

        LOGGER.info("Recursive function for fib({}) took {} milliseconds to execute.", input, executionTime.toMillis());
    }
}
