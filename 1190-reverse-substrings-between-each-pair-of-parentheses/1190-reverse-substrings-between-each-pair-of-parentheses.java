class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ')') {
                stack.push(ch);
            } else {

                ArrayList<Character> list = new ArrayList<>();

                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }

                stack.pop(); 

                for (char c : list) {
                    stack.push(c);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}