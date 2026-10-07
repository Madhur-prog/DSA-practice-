import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {

        solve(s, 0, 0, "", 0);

        return ans;
    }

    void solve(String s, int index, int openCount,
               String curr, int removed) {


        if (openCount < 0) {
            return;
        }

        if (index == s.length()) {

            if (openCount != 0) {
                return;
            }

            if (removed < minRemoved) {
                ans.clear();
                set.clear();

                ans.add(curr);
                set.add(curr);

                minRemoved = removed;
            }
            else if (removed == minRemoved && !set.contains(curr)) {
                ans.add(curr);
                set.add(curr);
            }

            return;
        }

        char ch = s.charAt(index);
        if (Character.isLetter(ch)) {

            solve(s,
                  index + 1,
                  openCount,
                  curr + ch,
                  removed);
        }
        else if (ch == '(') {

    solve(s,
          index + 1,
          openCount + 1,
          curr + ch,
          removed);

    solve(s,
          index + 1,
          openCount,
          curr,
          removed + 1);

}   

else {

    if (openCount > 0) {
        solve(s,
              index + 1,
              openCount - 1,
              curr + ch,
              removed);
    }

    solve(s,
          index + 1,
          openCount,
          curr,
          removed + 1);
}
    }
}