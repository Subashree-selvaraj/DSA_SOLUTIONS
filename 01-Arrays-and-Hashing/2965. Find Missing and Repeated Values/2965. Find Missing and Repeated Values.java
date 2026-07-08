public class Solution {
    public int[] FindMissingAndRepeatedValues(int[][] grid) {
        var n = grid.Length;
        var diff = 0;
        var sumDiff = 0;
        var squareSumDiff = 0;
        for (var row = 0; row < n; row++)
        {
            for (var col = 0; col < n; col++)
            {
                diff++;
                sumDiff += grid[row][col] - diff;
                squareSumDiff += grid[row][col] * grid[row][col] - diff * diff;
            }
        }

        if (sumDiff == 0)
        {
            return [];
        }

        var repeat = (squareSumDiff / sumDiff + sumDiff) / 2;
        var missing = (squareSumDiff / sumDiff - sumDiff) / 2;

        return [repeat, missing];
    }
}