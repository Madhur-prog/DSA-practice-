class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String,String>map=new HashMap<>();

        for (List<String>list:knowledge){
            map.put(list.get(0),list.get(1));

            }

        StringBuilder ans=new StringBuilder();
        int start=-1;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if (c=='('){
                start=i;
             }
             else if (c==')'){
                String n=s.substring(start+1,i);
                ans.append(map.getOrDefault(n,"?"));
                start=-1;

             }else if(start<0){
                ans.append(c);

             }
        }
        return ans.toString();


        
    }
}