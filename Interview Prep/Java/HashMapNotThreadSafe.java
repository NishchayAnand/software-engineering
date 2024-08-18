
import java.util.*;
import java.math.*;

public class HashMapNotThreadSafe {

    private static Map<Integer, Boolean> cache = new HashMap<>();

    // is this method threadsafe? -> No
    /**
     * @param x integer to test for primeness; requires x > 1
     * @return true if x is prime with high probability
     */
    public static boolean isPrime(int x) {
        if (cache.containsKey(x))
            return cache.get(x);
        boolean answer = BigInteger.valueOf(x).isProbablePrime(100);
        cache.put(x, answer);
        return answer;
    }

}
