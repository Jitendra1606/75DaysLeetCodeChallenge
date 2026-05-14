class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;

        int[] ans = new int[n1 + n2];
        int k = 0;

        while (i < n1 && j < n2) {

            if (nums1[i] <= nums2[j]) {
                ans[k] = nums1[i];
                i++;
                k++;
            } else {
                ans[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < n1) {
            ans[k++] = nums1[i++];
        }
        while (j < n2) {
            ans[k++] = nums2[j++];
        }
        if ((n1 + n2) % 2 == 1)
            return (double) ans[(n1 + n2) / 2];
        else
            return (double) (ans[(n1 + n2) / 2] + ans[((n1 + n2) / 2) - 1]) / 2;
    }
}
//t.c = O(n1 + n2)
//s.c = O(n1 + n2)