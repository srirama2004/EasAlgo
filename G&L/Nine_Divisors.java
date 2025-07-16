
/*
Explanation:
Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.
*/

class Solution {
    public static int countNumbers(int n) {
        List<Integer> primes = sieve((int) Math.sqrt(n) + 1);
        int count = 0;

        // Case 1: Numbers of the form p^8
        for (int p : primes) {
            long power = 1L * p * p * p * p * p * p * p * p;
            if (power <= n) {
                count++;
            } else {
                break;
            }
        }

        // Case 2: Numbers of the form (p^2) * (q^2), where p ≠ q
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = 1L * primes.get(i) * primes.get(i);
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                long q2 = 1L * primes.get(j) * primes.get(j);
                if (p2 * q2 <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    // Helper function to generate primes using Sieve of Eratosthenes
    private static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }
}

