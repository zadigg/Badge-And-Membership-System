package com.group2.badgeandmembershipsystem.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class BadgeIDGenerator {
    public static String generateBadgeId(){
        AtomicInteger sequentialNumber = new AtomicInteger();
        int nextNumber = sequentialNumber.incrementAndGet();
        return Integer.toString(nextNumber);
    }
}
