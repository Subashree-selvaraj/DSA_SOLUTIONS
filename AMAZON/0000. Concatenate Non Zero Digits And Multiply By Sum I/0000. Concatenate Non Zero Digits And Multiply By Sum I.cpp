class Solution:
    def sumAndMultiply(self, n: int) -> int:
        _sum = ccd = 0
        mp = 1
        while n:
            n, m = divmod(n, 10)
            if m:
                ccd += m * mp
                mp *= 10
                _sum += m
        return ccd * _sum