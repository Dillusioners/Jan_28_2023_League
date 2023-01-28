import java.util.*;
class ABC{
private static double[] rad;
private static int[] primes;

public static void main(String[] args) {
    long t1 = System.currentTimeMillis();
    System.out.println(solve());
    long t2 = System.currentTimeMillis();
    System.out.println((double) (t2 - t1) / 1000.0);
}

public static void sieveRadArray(int lim) {
    rad = new double[lim];
    Arrays.fill(rad, 1);
    for (int x : primes) {
        for (int j = 1; x * j < lim; j++) {
            rad[j * x - 1] *= x;
        }
    }
}

private static void sievePrimesArray(int lim) {
    boolean[] isPrime = new boolean[lim + 1];
    Arrays.fill(isPrime, true);
    for (int i = 2; i * i <= lim; i++) {
        if (isPrime[i]) {
            for (int j = i; i * j <= lim; j++) {
                isPrime[i * j] = false;
            }
        }
    }
    ArrayList<Integer> prime_list = new ArrayList<Integer>();
    prime_list.add(2);
    for (int j = 3; j < lim; j++) {
        if (isPrime[j]) {
            prime_list.add(j);
        }
    }
    primes = prime_list.stream().mapToInt(i -> i).toArray();
}

private static long solve() {
    final int lim = 110000;
    long sumc = 0;
    sievePrimesArray(lim);
    sieveRadArray(lim);
    for (int a = 1; a < lim; a++) {

        boolean[] notcoprime = new boolean[lim - a - 1];
        for (int i = 0; i < primes.length && primes[i] <= a; i++) {
            if (a % primes[i] == 0) {
                // We need `primes[i]*j>=a+1`

                for (int j = (a + 1) / primes[i] + (((a + 1) / primes[i] < a + 1) ? 1 : 0);
                     primes[i] * j < lim; j++) {
                    notcoprime[primes[i] * j - (a + 1)] = true;
                }
            }
        }
        for (int b = a + 1; b + a < lim; b++) {
            int c = a + b;
            if (!notcoprime[b - (a + 1)]) {

            
                if (rad[a-1] * rad[b-1] < (double) c / rad[c-1]) {
                    sumc += c;
                }
            }
        }
    }
    return sumc;
}
}
