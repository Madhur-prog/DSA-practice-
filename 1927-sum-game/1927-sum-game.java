class Solution {
    public boolean sumGame(String num) {

        int n = num.length();
        int mid = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftqc = 0;
        int rightqc = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < mid) {
                if (ch == '?') {
                    leftqc++;
                } else {
                    leftSum += ch - '0';
                }
            } else {
                if (ch == '?') {
                    rightqc++;
                } else {
                    rightSum += ch - '0';
                }
            }
        }

        int tq = leftqc + rightqc;

        if (tq % 2 == 1) {
            return true;
        }

        int diff = leftSum - rightSum;
        int qDiff = leftqc - rightqc;

        return diff != -(qDiff / 2) * 9;
    }
}