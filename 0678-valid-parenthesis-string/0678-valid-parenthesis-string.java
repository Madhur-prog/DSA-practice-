import java.util.*;

class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> os = new Stack<>();
        Stack<Integer> ss= new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                os.push(i);
            }
            else if (ch == '*') {
                ss.push(i);
            }
            else { // ')'

                if (!os.isEmpty()) {
                    os.pop();
                }
                else if (!ss.isEmpty()) {
                    ss.pop();
                }
                else {
                    return false;
                }
            }
        }

        while (!os.isEmpty() && !ss.isEmpty()) {

            int oi = os.pop();
            int si = ss.pop();

            if (oi > si) {
                return false;
            }
        }

        return os.isEmpty();
    }
}