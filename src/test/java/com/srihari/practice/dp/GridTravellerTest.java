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
public class GridTravellerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridTravellerTest.class.getName());

    private final GridTraveller sut;

    public GridTravellerTest() {
        this.sut = new GridTraveller();
    }

    @Test
    public void testRecursiveGridTraveller() {
        int rows = 18;
        int columns = 18;
        BigInteger expectedOutput = BigInteger.valueOf(2333606220L);
        AtomicReference<BigInteger> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.findNumberOfPathsRecursive(rows, columns));
            LOGGER.info("Recursive: Found {} paths to traverse for {}x{} grid", result, rows, columns);
        });

        assertEquals(
                String.format("Expected [%s] available paths for %dx%d grid. But found: %s", expectedOutput, rows, columns, result),
                expectedOutput,
                result.get()
        );

        LOGGER.info("Recursive function to get number of paths through grid of size {}x{} took {} milliseconds to execute.",
                rows, columns, executionTime.toMillis());
    }

    @Test
    public void testMemoizedGridTraveller() {
        int rows = 18;
        int columns = 18;
        BigInteger expectedOutput = BigInteger.valueOf(2333606220L);
        AtomicReference<BigInteger> result = new AtomicReference<>();
        Duration executionTime = Timer.timed(() -> {
            result.set(this.sut.findNumberOfPathsMemoized(rows, columns));
            LOGGER.info("Memoized: Found {} paths to traverse for {}x{} grid", result, rows, columns);
        });

        assertEquals(
                String.format("Expected [%s] available paths for %dx%d grid. But found: %s", expectedOutput, rows, columns, result),
                expectedOutput,
                result.get()
        );

        LOGGER.info("Recursive function to get number of paths through grid of size {}x{} took {} milliseconds to execute.",
                rows, columns, executionTime.toMillis());
    }
}
