int largestInteger(vector<int>& nums, int k) {
    int freq[51] = {0};
    for (auto& x : nums)
        freq[x]++;

    int res = -1, n = nums.size();
    for (int i = 0; i < n; i++) {
        // all elements qualify
        if (k == n)
            res = max(res, nums[i]);
        // Unique elements only
        else if (freq[nums[i]] == 1) {
            // any unique element qualifies
            if (k == 1)
                res = max(res, nums[i]);
            // boundary elements only
            else if (!i || i == n - 1)
                res = max(res, nums[i]);
        }
    }
    return res;
}