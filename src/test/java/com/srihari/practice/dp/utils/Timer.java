package com.srihari.practice.dp.utils;

import java.time.Duration;
import java.time.Instant;

public class Timer {

    public static Duration timed(Runnable function) {
        Instant before = Instant.now();
        function.run();
        Instant after = Instant.now();
        return Duration.between(before, after);
    }
}
