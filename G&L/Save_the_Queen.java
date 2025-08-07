
/*
Explanation:
The kingdom of Zokoria is under attack! The invaders wish to capture the Queen and conquer Zokoria. Aware of the danger, Heldorf , the captain of the Zokorian army must devise an exit strategy for the Queen.

In order to do so, the invaders must be kept at bay for a period of time. There are  invaders who must be engaged in fight for as long as possible. The army has  soldiers, with each having the capability to fight for a total of  seconds. The soldiers can fight against any invader at any time i.e. they can move to fight with another invader by dropping the current fight.

Heldorf wants you to find out how long does he have to help the Queen escape. You have to find the maximum possible time for which all the  invaders can be kept busy?

Input Format

The first line of input contains two numbers  and  - the number of invaders and the number of soldiers respectively.

The next line contains  numbers, each integer representing the time for which the respective soldier can engage in a fight.

Constraints

The time for which each solider can fight, , lies between  and .
Output Format

Print the maximum possible time for which the  invaders can be engaged in a fight. The number should be accurate up to  absolute precision.
*/

import java.util.*;

public class MaxPossibleAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Total elements to select
        int k = sc.nextInt(); // Number of given elements
        int[] a = new int[k];

        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt(); // Input array elements
        }

        double low = 0.0, high = 1e15, mid = 0.0;
        for (int i = 0; i < 100000; i++) {
            mid = (low + high) / 2.0;
            int requiredCount = n; // Number of values we need to choose
            double requiredSum = 0.0;

            for (int j = 0; j < k; j++) {
                if (a[j] >= mid) {
                    // This value is large enough to directly contribute
                    requiredCount--;
                } else {
                    // Otherwise, we sum it up to distribute later
                    requiredSum += a[j];
                }
            }

            if (requiredCount <= 0) {
                // Already got enough large values
                low = mid;
                continue;
            }

            // Average value we can get from remaining sum
            double averageFromRest = requiredSum / requiredCount;

            if (averageFromRest < mid) {
                // Not enough to reach 'mid' as average
                high = mid;
            } else {
                // It's possible to reach 'mid', try for a bigger one
                low = mid;
            }
        }

        System.out.printf("%.9f\n", mid);
    }
}

