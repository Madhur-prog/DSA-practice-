class Solution {
    public int minAddToMakeValid(String s) {
        int openb=0;
        int minaddc=0;

        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if (ch=='('){
                openb++;

            }else{
                if (openb>0){
                    openb--;

                }else{
                    minaddc++;

                }
            }

        }
         return openb+minaddc;


        
    }
}