
/*
Explanation:
Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher frequency than the current element.
If no such element exists, return -1 for that position.
*/

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        Map<Integer, Integer> frequencyTable = new HashMap<>();
        int sol[] = new int[arr.length];
        Stack<Integer> rightElements = new Stack<>();
        rightElements.push(-1);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            frequencyTable.put(arr[i], frequencyTable.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Integer element = arr[i];
            while ((rightElements.peek() != -1) &&
                   (frequencyTable.get(element) >= frequencyTable.get(rightElements.peek()))) {
                rightElements.pop();
            }
            sol[i] = rightElements.peek();
            rightElements.push(element);
        }

        for (int i : sol) {
            ans.add(i);
        }
        return ans;
    }
}
