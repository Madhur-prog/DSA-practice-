class Solution {
    public String removeOuterParentheses(String s) {
        int bcount = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                 if (bcount > 0) {
                   ans.append(ch);
                }
                bcount++;
            } else {
                bcount--;
                if (bcount > 0) {
                   ans.append(ch);
             }
           }
        }

        return ans.toString();
    }
}