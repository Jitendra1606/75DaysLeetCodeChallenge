class NumArray {
    int n;
    int[] segment;

    public NumArray(int[] nums) {
        n = nums.length;
        segment = new int[4 * n];

        buildSegment(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        updateSegment(index, val, 0, 0, n - 1); //update point in a segment tree
    }

    public int sumRange(int left, int right) {
        return querySegment(left, right, 0, 0, n - 1); //range query
    }

    public void buildSegment(int i, int l, int r, int[] nums) {
        if (l == r) {
            segment[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegment(2 * i + 1, l, mid, nums);
        buildSegment(2 * i + 2, mid + 1, r, nums);

        segment[i] = segment[2 * i + 1] + segment[2 * i + 2];
    }

    public void updateSegment(int index, int val, int i, int l, int r) {
        if (l == r) {
            segment[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            updateSegment(index, val, 2 * i + 1, l, mid);
        } else {
            updateSegment(index, val, 2 * i + 2, mid + 1, r);
        }
        segment[i] = segment[2 * i + 1] + segment[2 * i + 2];
    }

    public int querySegment(int start, int end, int i, int l, int r) {
        if (l > end || r < start)
            return 0;

        if (l >= start && r <= end) {
            return segment[i];
        }

        int mid = l + (r - l) / 2;

        return querySegment(start, end, 2 * i + 1, l, mid) + querySegment(start, end, 2 * i + 2, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */