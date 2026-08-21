class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        //sort the pair in descending order according to nums2
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0, max = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i][0];
            pq.offer(arr[i][0]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                max = Math.max(max, arr[i][1] * sum);
            }
        }
        return max;
    }
}

// Suppose:

// nums1 = [1, 3, 3, 2]
// nums2 = [2, 1, 3, 4]
// k = 2

// Make pairs:

// (nums1, nums2)

// (1,2)
// (3,1)
// (3,3)
// (2,4)

// Sort by nums2 descending:

// (2,4)
// (3,3)
// (1,2)
// (3,1)

// Now when we're at:

// (3,3)

// if we select this element plus previously processed elements, we know:

// minimum nums2 = 3

// because every previously processed element has nums2 >= 3.

// So we only need to maximize the sum of the largest k nums1 values among the elements processed so far.

// That's exactly what a min-heap is useful for.