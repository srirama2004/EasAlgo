
/*
Explanation:
Given an array of integers asteroids, where each integer represents an asteroid in a row, determine the state of the asteroids after all collisions. In this array, the absolute value represents the size of the asteroid, and the sign represents its direction (positive meaning right and negative meaning left). All asteroids move at the same speed.
When two asteroids meet, the smaller one will explode. If they are the same size, both will explode. Asteroids moving in the same direction will never meet.
*/

class Solution {
    public int[] asteroidCollision(int[] asteriods) {
    int n=asteriods.length;
    List<Integer>st=new ArrayList<>();
    for(int i=0;i<n;i++){
        if(asteriods[i]>0)
        st.add(asteriods[i]);
        else{
            while(!st.isEmpty() && st.get(st.size()-1)>0 && st.get(st.size()-1)<Math.abs(asteriods[i]))
            st.remove(st.size()-1);
            if(!st.isEmpty()&& st.get(st.size()-1)==Math.abs(asteriods[i])){
                st.remove(st.size()-1);
            }
            else if(st.isEmpty()|| st.get(st.size()-1)<0)
            st.add(asteriods[i]);
        }
    }
     int[] result = new int[st.size()];
        for(int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}
