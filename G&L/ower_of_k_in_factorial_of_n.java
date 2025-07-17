
/*
Explanation:
Given two positive integers n and k, determine the highest value of x such that kx divides n! (n factorial) completely (i.e., n % (kx) == 0).
*/

class Solution {

    // Helper to factorize k
    private Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            map.put(k, 1);
        }
        return map;
    }

    // Count how many times prime p divides n!
    private int countPrimeInFactorial(int n, int p) {
        int count = 0;
        while (n > 0) {
            n /= p;
            count += n;
        }
        return count;
    }

    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int minPower = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();
            int exponentInFactorial = countPrimeInFactorial(n, prime);
            minPower = Math.min(minPower, exponentInFactorial / exponentInK);
        }

        return minPower;
    }
}

