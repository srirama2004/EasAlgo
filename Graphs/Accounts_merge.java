
/*
Explanation:
Given a list of accounts where each element account [i] is a list of strings, where the first element account [i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order.
*/

class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
       int n=accounts.size();
       DisjointSet ds=new DisjointSet(n);
       Map<String,Integer>mapMailNode=new HashMap<>();
       for(int i=0;i<n;i++){
        for(int j=1;j<accounts.get(i).size();j++){
            String mail=accounts.get(i).get(j);
            if(!mapMailNode.containsKey(mail))
            mapMailNode.put(mail,i);
            else{
                ds.unionBySize(i,mapMailNode.get(mail));
            }
        }
       }
       List<List<String>> mergedMail=new ArrayList<>(n);
       for(int i=0;i<n;i++){
       mergedMail.add(new ArrayList<>());
       }
       for(Map.Entry<String,Integer>entry:mapMailNode.entrySet()){
        String mail=entry.getKey();
        int node=ds.findUPar(entry.getValue());
        mergedMail.get(node).add(mail);
       }
       List<List<String>>ans=new ArrayList<>();
       for(int i=0;i<n;i++){
        if(mergedMail.get(i).isEmpty())
        continue;
        Collections.sort(mergedMail.get(i));
        List<String>temp=new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        temp.addAll(mergedMail.get(i));
        ans.add(temp);
       }
       ans.sort(Comparator.comparing(list->list.get(0)));
       return ans;
    }
}
