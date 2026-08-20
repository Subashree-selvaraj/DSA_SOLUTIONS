    public int thirdMax(int[] nums) {
        Integer[] max = new Integer[3];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num == max[0] || (max[1] != null && num == max[1]) || (max[2] != null && num == max[2])) {
                continue;
            }

            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[1] == null) {
                max[1] = num;
            } else if (num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[2] == null || num > max[2]) {
                max[2] = num;
            }
        }
        return max[2] != null ? max[2] : max[0];
    }