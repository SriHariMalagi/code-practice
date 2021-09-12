package com.srihari.practice.dp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Timer {

    private static final Logger log = LoggerFactory.getLogger(Timer.class.getName());

    public static void timed(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        log.info("Took {} milliseconds for execution.", (endTime - startTime) / (1000.0 * 1000.0));
    }
}
