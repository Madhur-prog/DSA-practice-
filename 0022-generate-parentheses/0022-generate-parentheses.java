class Solution {
    public boolean isValid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else
                count--;

            if (count < 0)
                return false;
        }

        return count == 0;
    }
    public void generateAll(String curr, int n, List<String> res) {

        if (curr.length() == 2 * n) {
            if (isValid(curr))
                res.add(curr);
            return;
        }

        generateAll(curr + "(", n, res);
        generateAll(curr + ")", n, res);
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generateAll("", n, res);

        return res;
    }
}