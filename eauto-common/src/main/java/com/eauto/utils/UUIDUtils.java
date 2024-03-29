package com.eauto.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:16:44
 * Description: No Description
 */
public abstract class UUIDUtils {

    private static boolean IS_THREADLOCALRANDOM_AVAILABLE = false;
    private static Random random;
    private static final long   leastSigBits;
    private static final ReentrantLock lock = new ReentrantLock();
    private static long lastTime;

    static {
        try {
            IS_THREADLOCALRANDOM_AVAILABLE = null != UUIDUtils.class.getClassLoader().loadClass(
                    "java.util.concurrent.ThreadLocalRandom"
            );
        } catch(ClassNotFoundException e) {
        }

        byte[] seed = new SecureRandom().generateSeed(8);
        leastSigBits = new BigInteger(seed).longValue();
        if(!IS_THREADLOCALRANDOM_AVAILABLE) {
            random = new Random(leastSigBits);
        }
    }

    private UUIDUtils() {
    }

    /**
     * Create a new random UUID.
     *
     * @return the new UUID
     */
    public static String getID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Create a new random UUID.
     *
     * @return the new UUID
     */
    public static UUID getUUID(){
        return UUID.randomUUID();
    }

    /**
     * Create a new time-based UUID.
     *
     * @return the new UUID
     */
    public static UUID create() {
        long timeMillis = (System.currentTimeMillis() * 10000) + 0x01B21DD213814000L;

        lock.lock();
        try {
            if(timeMillis > lastTime) {
                lastTime = timeMillis;
            } else {
                timeMillis = ++lastTime;
            }
        } finally {
            lock.unlock();
        }

        // time low
        long mostSigBits = timeMillis << 32;

        // time mid
        mostSigBits |= (timeMillis & 0xFFFF00000000L) >> 16;

        // time hi and version
        mostSigBits |= 0x1000 | ((timeMillis >> 48) & 0x0FFF); // version 1

        return new UUID(mostSigBits, leastSigBits);
    }

}