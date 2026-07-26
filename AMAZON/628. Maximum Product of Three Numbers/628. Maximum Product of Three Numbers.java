class Solution {
public:
    int maximumProduct(vector<int>& A) {
        int a = -1001, b = a, c = b;    // max 3
        int x =  1001, y = x;           // min 2

        for (auto& n : A) {
            c = max(c, min(b, n));     // Shift to 3rd max
            b = max(b, min(a, n));     // Shift to 2nd max
            a = max(a, n);              // Update 1st max

            y = min(y, max(x, n));     // Shift to 2nd min
            x = min(x, n);              // Update 1st min
        }

        return max(a * b * c, a * x * y);
    }
};