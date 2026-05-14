class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length , n2 = nums2.length , i = 0 , j = 0;
        int n = n1 + n2;
        int ind1 = n / 2;
        int ind2 = ind1 - 1;
        int cnt = 0 , indel1 = -1 , indel2 = -1;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == ind1) indel1 = nums1[i];
                if(cnt == ind2) indel2 = nums1[i];
                cnt++;
                i++;
            }else{
                if(cnt == ind1) indel1 = nums2[j];
                if(cnt == ind2) indel2 = nums2[j];
                cnt++;
                j++;
            }
        } 
        while(i < n1){
            if(cnt == ind1) indel1 = nums1[i];
            if(cnt == ind2) indel2 = nums1[i];
            cnt++;
            i++;
        }
        while(j < n2){
            if(cnt == ind1) indel1 = nums2[j];
            if(cnt == ind2) indel2 = nums2[j];
            cnt++;
            j++;
        }
        if(n % 2 == 1){
            return indel1;
        }
        return (double)((double)(indel1 + indel2)) / 2.0;
    }
}

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//         int n1 = nums1.length, n2 = nums2.length;
//         int i = 0, j = 0;

//         int[] ans = new int[n1 + n2];
//         int k = 0;

//         while (i < n1 && j < n2) {

//             if (nums1[i] <= nums2[j]) {
//                 ans[k] = nums1[i];
//                 i++;
//                 k++;
//             } else {
//                 ans[k] = nums2[j];
//                 k++;
//                 j++;
//             }
//         }

//         while (i < n1) {
//             ans[k++] = nums1[i++];
//         }
//         while (j < n2) {
//             ans[k++] = nums2[j++];
//         }
//         if ((n1 + n2) % 2 == 1)
//             return (double) ans[(n1 + n2) / 2];
//         else
//             return (double) (ans[(n1 + n2) / 2] + ans[((n1 + n2) / 2) - 1]) / 2;
//     }
// }
//t.c = O(n1 + n2)
//s.c = O(n1 + n2)