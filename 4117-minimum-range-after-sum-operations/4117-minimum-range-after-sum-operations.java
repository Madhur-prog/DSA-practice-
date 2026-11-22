      
class Solution {
    public int minRange(int a, int b, int c) {
        if (a + b < c) {
            c = a + b;
        }
        else if (a + c < b) {
            b = a + c;
        }
        else if (b + c < a) {
            a = b + c;
        }

        return Math.max(a, Math.max(b, c))
             - Math.min(a, Math.min(b, c));
    }
}