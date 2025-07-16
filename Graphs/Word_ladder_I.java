
/*
Explanation:
Given are the two distinct words startWord and targetWord, and a list of size N, denoting wordList of unique words of equal size M. Find the length of the shortest transformation sequence from startWord to targetWord.



Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList

Note: If there’s no possible way to transform the sequence from startWord to targetWord return 0.
*/

class Solution {
     static class Pair{
        String word;
        int steps;
         Pair(String word,int steps){
            this.word=word;
            this.steps=steps;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
     Queue<Pair>q=new LinkedList<>();
     q.add(new Pair(startWord,1));
     Set<String>st=new HashSet<>(wordList);
     st.remove(startWord);
     while(!q.isEmpty()){
        String word=q.peek().word;
        int steps=q.peek().steps;
        q.poll();
        if(word.equals(targetWord))
        return steps;
        for(int i=0;i<word.length();i++){
            char[] wordArray=word.toCharArray();
            for(char ch='a';ch<='z';ch++){
                wordArray[i]=ch;
                String newWord=new String(wordArray);
                if(st.contains(newWord)){
                    st.remove(newWord);
                    q.add(new Pair(newWord,steps+1));
                }
            }
        }
     }
     return 0;
    }
}

