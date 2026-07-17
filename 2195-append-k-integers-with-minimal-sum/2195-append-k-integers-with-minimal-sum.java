class Solution{
    public long minimalKSum(int[] nums, int k){
        int n = nums.length;
        long sum = 0;

        Arrays.sort(nums);

        long cur = 1;
        
        for(int i = 0 ; i < n ; i++){
            //skip duplicates or smaller than nums[i]
            if(cur > nums[i]) continue;  //array like = [1, 1, 2, 4]

            //missing num are in the gap [cur, nums[i] - 1]
            long gap = nums[i] - cur;

            if(gap > 0){
                long take = Math.min(gap, (long)k);
                long last = cur + take - 1;

                sum += (cur + last) * take / 2;  //arithmetic formula

                k -= take;

                if(k == 0) return sum;

                cur = last + 1;
            }

            //skip the current number
            cur = (long) nums[i] + 1;
        }

        //when our arrays element finished but k still remains
        long last = k + cur - 1;
        sum += (cur + last) * k / 2;

        return sum;
    }
}


// sum += (first + last) * cnt / 2;
// (2+3)*2/2 = 5




// class Solution {
//     public long minimalKSum(int[] nums, int k) {
//         int n = nums.length;

//         Arrays.sort(nums);
//         int[] hash = new int[10000001];

//         for(int i = 0 ; i < n ; i++){
//             hash[nums[i]]++;
//         }

//         long sum = 0;
//         for(int i = 1 ; i < 10000001 ; i++){
//             if(hash[i] == 0 && k > 0){
//                 sum += i;
//                 k--;
//             }
//             if(k == 0) break;
//         }

//         return sum;
//     }
// }